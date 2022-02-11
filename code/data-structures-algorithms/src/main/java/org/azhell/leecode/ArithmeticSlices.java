package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 413. 等差数列划分
 * 等差数列至少有三个元素
 * 子数组是一个连续序列
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        ArithmeticSlices a = new ArithmeticSlices();
        Utils.print(a.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        Utils.print(a.numberOfArithmeticSlices(new int[]{1}));
        Utils.print(a.numberOfArithmeticSlices(new int[]{7, 7, 7, 7}));
        Utils.print(a.numberOfArithmeticSlices(new int[]{3, -1, -5, -9}));
        Utils.print(a.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6}));
        Utils.print(a.numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        int diff = nums[1] - nums[0];
        int cnt = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                cnt += 1;
            } else {
                diff = nums[i] - nums[i - 1];
                cnt = 2;
            }
            // 根据不同类型，动态转移方程不一样
            if (cnt > 3) {
                dp[i] = cnt - 2 + dp[i - 1];
            } else if (cnt == 3) {
                dp[i] = 1 + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
