package org.azhell.leecode;

/**
 * 删除有序数组中的重复项
 * 使用快慢指针的方式，遇到重复值就将重复值的一个写入到前面去
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        System.out.println("count is " + count);
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        // 记录慢指针位置
        int i = 1;
        // 记录当前重复值
        int currentDuplicateValue = nums[0];
        // k其实就是快指针的位置
        for (int k = 1; k < nums.length; k++) {
            if (nums[k] != currentDuplicateValue) {
                currentDuplicateValue = nums[k];
                nums[i++] = nums[k];
            }
        }
        return i;
    }
}
