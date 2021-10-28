package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 下一个排列
 * 没有什么特殊的算法，总结规律
 */
public class NextPermutation {
    public static void main(String[] args) {
        // int[] nums = new int[]{1, 2, 3, 7, 6, 5, 4};
        int[] nums = new int[]{1, 3, 2};
        new NextPermutation().nextPermutation(nums);
        Utils.print(nums);
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // 倒序找出第一个升序的数据
        int numIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                numIndex = i;
                break;
            }
        }

        // 部分数据倒序
        if (numIndex != -1) {
            // 找出numIndex后面比这个数大的最小数
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[numIndex]) {
                    int temp = nums[numIndex];
                    nums[numIndex] = nums[i];
                    nums[i] = temp;
                    // 从i开始需要正序
                    break;
                }
            }
        }
        reverseArray(nums, numIndex + 1);
    }

    public void reverseArray(int[] nums, int index) {
        int maxIndex = nums.length - 1;
        for (int i = 0; i < (maxIndex - index) / 2 + 1; i++) {
            int temp = nums[index + i];
            nums[index + i] = nums[maxIndex - i];
            nums[maxIndex - i] = temp;
        }
    }
}
