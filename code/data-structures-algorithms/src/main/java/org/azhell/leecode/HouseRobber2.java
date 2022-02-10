package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 213. 打家劫舍 II
 * 本题是198题的延伸，动态转移方程和边界条件基本一致
 * 但是因为队列首尾相连的缘故，可以将队列拆成两部分，
 * [0,n-1]和[1,n]分别求dp，然后选择一个较大的方案
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 h = new HouseRobber2();
        Utils.print(h.rob(new int[]{2, 3, 2}));
        Utils.print(h.rob(new int[]{1, 2, 3, 1}));
        Utils.print(h.rob(new int[]{1, 2, 3}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n - 1];
        // 边界条件
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int ans = dp[n - 2];
        // 节省一个数组空间
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            dp[i - 1] = Math.max(dp[i - 3] + nums[i], dp[i - 2]);
        }
        return Math.max(ans, dp[n - 2]);
    }

}
