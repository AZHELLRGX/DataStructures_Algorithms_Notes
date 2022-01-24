package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Offer21 {
    public static void main(String[] args) {
        Offer21 o = new Offer21();
        Utils.print(o.exchange(new int[]{1, 2, 3, 4}));
        Utils.print(o.exchange(new int[]{}));
        Utils.print(o.exchange(new int[]{1, 2, 3, 4, 5, 6, 8, 7, 9, 1, 2, 3, 10, 23, 21, 12}));
    }

    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        // 下面的逻辑一开始写的有点复杂了，空间复杂度略高，优化后提升
        while (i < j) {
            if (nums[i] % 2 == 1) {
                i++;
            } else if (nums[j] % 2 == 0) {
                j--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }
}
