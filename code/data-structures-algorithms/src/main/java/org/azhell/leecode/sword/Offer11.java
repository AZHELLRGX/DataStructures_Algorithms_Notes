package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 154. 寻找旋转排序数组中的最小值 II
 * 还是尝试二分解题
 */
public class Offer11 {
    public static void main(String[] args) {
        Offer11 o = new Offer11();
        Utils.print(o.minArray(new int[]{3, 4, 5, 1, 2}));
        Utils.print(o.minArray(new int[]{2, 2, 2, 0, 2}));
        Utils.print(o.minArray(new int[]{1}));
        Utils.print(o.minArray(new int[]{1, 1}));
    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                // 由于有重复值的情况, 需要加入 mid 元素等于 right 元素的情况，此时应该将 right 减 1 防止重复数字是最小元素
                right--;
            }
        }
        return numbers[left];
    }
}
