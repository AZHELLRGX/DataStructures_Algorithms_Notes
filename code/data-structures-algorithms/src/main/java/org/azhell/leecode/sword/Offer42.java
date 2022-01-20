package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 这道题之前做过，但是可以重新做一遍
 */
public class Offer42 {
    public static void main(String[] args) {
        Offer42 o = new Offer42();
        Utils.print(o.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Utils.print(o.maxSubArray(new int[]{-3, -1, -2}));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int previousSum = nums[0];
        int maxSum = previousSum;
        for (int i = 1; i < nums.length; i++) {
            if (previousSum > 0) {
                previousSum = nums[i] + previousSum;
            } else {
                previousSum = nums[i];
            }
            maxSum = Math.max(previousSum, maxSum);
        }
        return maxSum;
    }
}
