package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 数组有序一般解题思路都是二分查找
 */
public class Offer53 {
    public static void main(String[] args) {
        Offer53 o = new Offer53();
        // 测试1
        Utils.print(o.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Utils.print(o.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Utils.print(o.search(new int[]{1}, 1));
        Utils.print(o.search(new int[]{2, 2}, 2));

        // 测试2
        Utils.print("-------------");
        Utils.print(o.missingNumber(new int[]{0, 1, 3}));
        Utils.print(o.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
        Utils.print(o.missingNumber(new int[]{0, 2, 3}));
        Utils.print(o.missingNumber(new int[]{1}));
        Utils.print(o.missingNumber(new int[]{1, 2}));
    }

    /*
    1、在排序数组中查找数字
    二分查找,找到后往前往后查找
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 前后查看重复数据
                int repeatCnt = 1;
                int i = mid - 1;
                while (i >= 0 && nums[i] == nums[mid]) {
                    repeatCnt++;
                    i--;
                }
                i = mid + 1;
                while (i < nums.length && nums[i] == nums[mid]) {
                    repeatCnt++;
                    i++;
                }
                return repeatCnt;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    /*
    2、0～n-1中缺失的数字
    依旧是二分查找
    有且只有一个数字不在该数组中
     */
    public int missingNumber(int[] nums) {
        int maxNum = nums.length - 1;
        // 缺失数据是最后一位的特例单独判断，不需要走二分
        if (nums[maxNum] == maxNum) {
            return maxNum + 1;
        }
        int left = 0;
        int right = maxNum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 只有两种情况，要么等于，要么小于
            if (mid == nums[mid]) {
                // 缺失的数字在右边
                left = mid + 1;
            } else {
                // 缺失的数据在左边，而且可以直接计算出来
                right = mid - 1;
            }
        }
        return nums[left] - 1;
    }

}
