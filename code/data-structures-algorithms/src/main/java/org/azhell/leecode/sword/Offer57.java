package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 57. 和为s的两个数字
 */
public class Offer57 {
    public static void main(String[] args) {
        Offer57 o = new Offer57();
        Utils.print(o.twoSum(new int[]{2, 7, 11, 15}, 9));
        Utils.print(o.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40));
        Utils.print(o.twoSum(new int[]{10, 26, 30, 31, 47, 60, 61, 62, 63}, 92));
    }

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        while (left < right) {
            final int temp = nums[left] + nums[right];
            if (temp == target) {
                result[0] = nums[left];
                result[1] = nums[right];
                return result;
            } else if (temp > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}
