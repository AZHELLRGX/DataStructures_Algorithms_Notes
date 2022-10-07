package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1800. 最大升序子数组和
 */
public class MaximumAscendingSubarraySum {

    public static void main(String[] args) {
        MaximumAscendingSubarraySum m = new MaximumAscendingSubarraySum();
        Utils.print(m.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        Utils.print(m.maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        Utils.print(m.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
    }

    public int maxAscendingSum(int[] nums) {
        int curSum = 0;
        int maxSum = 0;
        int previous = 0;
        for (int num : nums) {
            if (num > previous) {
                curSum += num;
            } else {
                maxSum = Math.max(curSum, maxSum);
                curSum = num;
            }
            previous = num;

        }
        return Math.max(maxSum, curSum);
    }
}
