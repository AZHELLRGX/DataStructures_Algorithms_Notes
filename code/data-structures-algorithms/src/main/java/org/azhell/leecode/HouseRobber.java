package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 198. 打家劫舍
 * 主要还是对边界条件和动态转移方程的理解
 */
public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        Utils.print(h.rob(new int[]{1, 2, 3, 1}));
        Utils.print(h.rob(new int[]{2, 7, 9, 3, 1}));
        Utils.print(h.rob(new int[]{2, 1, 1, 2}));
        Utils.print(h.rob(new int[]{2, 1}));
        Utils.print(h.rob(new int[]{2}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        // 边界条件
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 状态转移
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
