package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 162. 寻找峰值
 * 为什么二分查找大的那一半一定会有峰值呢？
 * （即nums[mid]<nums[mid+1]时，mid+1~N一定存在峰值）
 * 我的理解是，首先已知 nums[mid+1]>nums[mid]，
 * 那么mid+2只有两种可能，一个是大于mid+1，
 * 一个是小于mid+1，小于mid+1的情况，那么mid+1就是峰值，
 * 大于mid+1的情况，继续向右推，如果一直到数组的末尾都是大于的，
 * 那么可以肯定最后一个元素是峰值，因为nums[nums.length]=负无穷
 * 有如下规律：
 * 规律一：如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素
 * 规律二：如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素
 * <p>
 * 做完这道题我大概知道了二分查找的两个模版
 */
public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        Utils.print(f.findPeakElement(new int[]{1, 2, 3, 1}));
        Utils.print(f.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
