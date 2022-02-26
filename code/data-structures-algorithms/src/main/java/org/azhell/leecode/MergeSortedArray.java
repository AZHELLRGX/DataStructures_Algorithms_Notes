package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 88. 合并两个有序数组
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        m.merge(nums1, 3, nums2, 3);
        Utils.print(nums1);
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        m.merge1(nums1, 3, nums2, 3);
        Utils.print(nums1);
    }

    // 新的方案使用从后往前遍历的思路
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i < 0 || nums1[i] <= nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }

    // 老方案使用的是直接插入排序思想
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            // 从后往前开始找到比num小的数
            int j = m + i;
            while (j > 0 && nums2[i] < nums1[j - 1]) {
                nums1[j] = nums1[j - 1];
                j--;
            }
            // 插入
            nums1[j] = nums2[i];
        }
    }
}
