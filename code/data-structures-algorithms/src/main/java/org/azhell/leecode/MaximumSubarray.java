package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 53. 最大子序和
 * 动态规划
 * 动态规划是一个大课题，需要慢慢领悟
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Utils.print(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Utils.print(new MaximumSubarray().maxSubArray(new int[]{1}));
        Utils.print(new MaximumSubarray().maxSubArray(new int[]{0}));
        Utils.print(new MaximumSubarray().maxSubArray(new int[]{-100000}));
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = sum;
        for (int i = 1; i < nums.length; i++) {
            // 子问题的解对新问题是有增益的，继续保留
            if (sum >= 0) {
                sum += nums[i];
            }
            // 子问题的解对新问题是无增益的，舍弃不要
            else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
