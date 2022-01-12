package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 300. 最长递增子序列
 * LIS longest increment sequence
 * 经典动态规划算法之一
 * f(1) = 1
 * f(x) 的 递增子序列长度需要根据 f(x-1)判定而来，
 * 判定方法是将元素a[x]与[0,x-1]范围的所有元素比较
 * 找到可以形成递增的a[i]，形成新的最长递增子序列
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        Utils.print(l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Utils.print(l.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        Utils.print(l.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        Utils.print(l.lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int longest = 0;
        if (len == 0) {
            return longest;
        }
        int[] dp = new int[len];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}
