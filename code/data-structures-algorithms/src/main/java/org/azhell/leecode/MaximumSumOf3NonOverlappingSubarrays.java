package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 689. 三个无重叠子数组的最大和
 * 还是尝试动态规划解题
 * 经典的拿空间换时间
 * todo 动态规划的效率比较低，后续有时间试试官方解题思路：滑动窗口
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args) {
        MaximumSumOf3NonOverlappingSubarrays m = new MaximumSumOf3NonOverlappingSubarrays();
        Utils.print(m.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2));
        Utils.print(m.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 2));
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // 记录每个滑动窗口k个数字的和
        int[] sumArray = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                sumArray[i] += nums[i + j];
            }
        }
        // 从左检索和从右侧检索的时候，应该选择sumArray哪个索引的值；下面两个数组都存放索引值
        int[] leftArray = new int[sumArray.length];
        int[] rightArray = new int[sumArray.length];
        int maxIndex = 0;
        for (int i = 0; i < sumArray.length; i++) {
            if (sumArray[i] > sumArray[maxIndex]) {
                maxIndex = i;
            }
            leftArray[i] = maxIndex;
        }
        maxIndex = sumArray.length - 1;
        for (int i = sumArray.length - 1; i >= 0; i--) {
            // 从右往左，需要判断等于
            if (sumArray[i] >= sumArray[maxIndex]) {
                maxIndex = i;
            }
            rightArray[i] = maxIndex;
        }
        int[] result = new int[]{-1, -1, -1};
        // 对于任何一个值，都可以快速的借助辅助数组left和right，找到左侧以及右侧最大最小的值
        for (int i = k; i < sumArray.length - k; i++) {
            if (result[0] == -1 || sumArray[result[0]] + sumArray[result[1]] + sumArray[result[2]] <
                    sumArray[i] + sumArray[leftArray[i - k]] + sumArray[rightArray[i + k]]) {
                result[0] = leftArray[i - k];
                result[1] = i;
                result[2] = rightArray[i + k];
            }
        }
        return result;
    }
}
