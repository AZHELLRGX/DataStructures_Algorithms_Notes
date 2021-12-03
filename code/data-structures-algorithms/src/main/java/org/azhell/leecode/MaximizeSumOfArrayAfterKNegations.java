package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 先排序然后   贪心算法  其实就是一直修改数组的最开始一位数据
 * 当然改完以后为了不排序，就需要记录转换后对整体影响最小的那个数据
 */
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        MaximizeSumOfArrayAfterKNegations m = new MaximizeSumOfArrayAfterKNegations();
        Utils.print(m.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        Utils.print(m.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        Utils.print(m.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        // 记录一个最小值
        nums[0] = -nums[0];
        int minNum = nums[0];
        int minIndex = 0;
        for (int i = 1; i <= k - 1; i++) {
            if (i < nums.length && nums[i] < minNum) {
                nums[i] = -nums[i];
                minNum = nums[i];
                minIndex = i;
            } else {
                // 不断的转换最小值即可
                nums[minIndex] = -nums[minIndex];
            }
        }
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }
}
