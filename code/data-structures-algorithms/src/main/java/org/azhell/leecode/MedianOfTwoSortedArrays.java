package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 4. 寻找两个正序数组的中位数
 * 自己的思路：两个有序数组先合并，然后再找中位数
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 6};
        int[] nums2 = {2, 4, 5};
        Utils.print(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums3[k++] = nums1[i++];
                } else {
                    nums3[k++] = nums2[j++];
                }
            } else if (i < nums1.length) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        if (nums3.length % 2 == 1) {
            return nums3[nums3.length / 2];
        } else {
            return (double) (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2;
        }
    }
}
