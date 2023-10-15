package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 128. 最长连续序列
 */
public class Q128 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 1};
        Utils.print(new Q128().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int pre = nums[0];
        int ans = 1;
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (pre == num - 1) {
                sum += 1;
            } else if (pre != num) {
                sum = 1;
            }
            pre = num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
