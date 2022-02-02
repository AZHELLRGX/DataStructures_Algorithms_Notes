package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 209. 长度最小的子数组
 * 滑动窗口类型的经典题目
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        Utils.print(m.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        Utils.print(m.minSubArrayLen(4, new int[]{1, 4, 4}));
        Utils.print(m.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            // 先将右侧数字加上
            sum += nums[right];
            // 判断左侧可以减多少
            while (sum - nums[left] >= target && left <= right) {
                sum -= nums[left];
                left += 1;
            }
            if (sum >= target)
                ans = ans == 0 ? right - left + 1 : Math.min(ans, right - left + 1);
            right += 1;
        }
        return ans;
    }
}
