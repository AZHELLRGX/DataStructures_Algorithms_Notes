package org.azhell.leecode.interview;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 面试题 17.19. 消失的两个数字
 * 解题思路一：抽屉排序
 */
public class MissingTwoLCCI {
    public static void main(String[] args) {
        MissingTwoLCCI m = new MissingTwoLCCI();
        int[] nums = new int[]{1};
        Utils.print(m.missingTwo(nums));
        nums = new int[]{2, 3};
        Utils.print(m.missingTwo(nums));
    }

    public int[] missingTwo(int[] nums) {
        int[] result = new int[2];
        // 没办法，java的数组扩容比较傻，这里不满足0(1)的空间复杂度
        int[] newNums = Arrays.copyOf(nums, nums.length + 2);
        for (int i = 0; i < newNums.length; i++) {
            // 抽屉排序，持续交换
            while (newNums[i] != 0 && newNums[i] != i + 1) {
                int a = newNums[i];
                newNums[i] = newNums[a - 1];
                newNums[a - 1] = a;
            }
        }
        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] == 0) {
                result[j++] = i + 1;
                if (j == 2) break;
            }

        }
        return result;
    }
}
