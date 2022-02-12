package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 673. 最长递增子序列的个数
 * 本题与300题大致类似，但是dp数组不仅需要保存最长递增序列长度，还需要保存个数
 * 所以考虑使用一个额外的数组来保存组合数量
 */
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence n = new NumberOfLongestIncreasingSubsequence();
        Utils.print(n.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        Utils.print(n.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        Utils.print(n.findNumberOfLIS(new int[]{2, 2, 2, 3, 2}));
        Utils.print(n.findNumberOfLIS(new int[]{2, 2, 3, 2, 2, 2, 3}));
        Utils.print(n.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] lenDp = new int[n];
        int[] cntDp = new int[n];
        int longest = 1;
        for (int i = 0; i < n; i++) {
            lenDp[i] = 1;
            cntDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lenDp[i] < lenDp[j] + 1) {
                        lenDp[i] = lenDp[j] + 1;
                        cntDp[i] = cntDp[j];
                    } else if (lenDp[i] == lenDp[j] + 1) {
                        cntDp[i] += cntDp[j];
                    }
                }
            }
            longest = Math.max(longest, lenDp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (lenDp[i] == longest) {
                ans += cntDp[i];
            }
        }
        return ans;
    }
}
