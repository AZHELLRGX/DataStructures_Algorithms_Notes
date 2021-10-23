package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 移除元素
 * 这个题目和前一题目很类似，还是继续使用快慢指针解题
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int count = new RemoveElement().removeElement(nums, 2);
        Utils.print("count is " + count);
        for (int i = 0; i < count; i++) {
            Utils.print(nums[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length <= 0) {
            return nums.length;
        }

        // 记录慢指针位置
        int i = 0;
        // k其实就是快指针的位置
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != val) {
                nums[i++] = nums[k];
            }
        }
        return i;
    }
}

