package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 713. 乘积小于K的子数组
 * <p>
 * 本题双指针解法不是难点
 * 难点在于计算一个窗口内部的子串数量，而且不能重复
 * 必须包含窗口中中最后一个数字的子串数量是r - l + 1
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
        Utils.print(s.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        Utils.print(s.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
        Utils.print(s.numSubarrayProductLessThanK(new int[]{2, 2, 2}, 3));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // nums的数据最小为1
        if (k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 1;
        int ans = 0;
        while (right < nums.length) {
            sum *= nums[right];
            while (sum >= k && left <= right) {
                sum /= nums[left];
                left += 1;
            }
            // 本题核心
            ans += right - left + 1;
            right += 1;
        }
        return ans;
    }
}
