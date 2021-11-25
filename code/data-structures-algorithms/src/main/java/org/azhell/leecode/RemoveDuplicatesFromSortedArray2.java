package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 80. 删除有序数组中的重复项 II
 * 依旧是双指针解题
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        final RemoveDuplicatesFromSortedArray2 r = new RemoveDuplicatesFromSortedArray2();
        Utils.print(r.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        Utils.print(r.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        Utils.print(r.removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 3}));
    }

    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        int currentNum = nums[0];
        int numCount = 1;
        while (j < nums.length) {
            if (nums[j] == currentNum) {
                // 已经有两个重复值
                if (numCount < 2) {
                    numCount += 1;
                    // 只要是在允许范围内的都将其挪到前指针的位置，无论i != j是否成立
                    nums[i] = nums[j];
                    i++;
                }
            } else {
                currentNum = nums[j];
                numCount = 1;
                // 将新的数据写到i的位置
                nums[i] = nums[j];
                i++;
            }
            j++; // 跳过，扫描下一个
        }
        return i;
    }
}
