package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 缺失的第一个正数
 * 利用数组索引
 * 注意0不是正整数，而题目要求返回最小的正整数
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        Utils.print(new FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0}));
        Utils.print(new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1}));
        Utils.print(new FirstMissingPositive().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        Utils.print(new FirstMissingPositive().firstMissingPositive(new int[]{2, 1}));
        Utils.print(new FirstMissingPositive().firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10}));
        Utils.print(new FirstMissingPositive().firstMissingPositive(new int[]{1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        // 将各个数字归位，注意1归位的索引是0
        for (int i = 0; i < nums.length; i++) {
            replaceNum(nums, i);
        }
        // 找不到当前存储的数据为位置不对应的第一个数据，就表示该位数据缺失了，返回当前位置的索引+1即可
        int result = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    // 替换两个位置的数据
    public void replaceNum(int[] nums, int i) {
        if (nums[i] != i + 1 && 0 < nums[i] && nums[i] < nums.length) {
            int originIndex = nums[i] - 1;
            if (nums[originIndex] != nums[i]) {
                int temp = nums[originIndex];
                nums[originIndex] = nums[i];
                nums[i] = temp;
                // 替换掉的数据依旧需要往下替换，直到无法替换为止,使用递归实现
                // 但是一定需要考虑数据重复的问题 否则1和1会一直循环替换下去
                replaceNum(nums, i);
            }
        }
    }
}
