package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * 复习一下快排
 */
public class Offer40 {
    public static void main(String[] args) {
        Offer40 o = new Offer40();
        Utils.print(o.getLeastNumbers(new int[]{3, 2, 1, 4, 5, 8, 7, 5, 3, 2, 9}, 2));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        sort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    // 先掌握递归写法的快排
    private void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        // 基准值
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        // 放置基准值，准备分治递归快排
        arr[left] = pivot;
        sort(arr, start, left - 1);
        sort(arr, left + 1, end);
    }
}
