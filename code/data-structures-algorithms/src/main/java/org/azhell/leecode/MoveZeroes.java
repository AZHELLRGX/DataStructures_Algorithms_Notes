package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 283. 移动零
 * 双指针，一个指针指向0，一个指向不为0的数据
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 0, 3, 12};
        m.moveZeroes(nums);
        Utils.print(nums);
    }

    public void moveZeroes(int[] nums) {
        int s = 0;
        int f = 1;
        while (f < nums.length) {
            if (nums[s] == 0) {
                if (nums[f] != 0) {
                    int temp = nums[f];
                    nums[f] = nums[s];
                    nums[s] = temp;
                    s += 1;
                }
            } else {
                s = f;
            }
            f += 1;
        }
    }
}
