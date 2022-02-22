package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 581. 最短无序连续子数组
 * 从左往右，找到最后一个降序排列的点 high
 * 从右到左，找到第一个升序排列的点 low
 * high - low 即可
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        Utils.print(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        Utils.print(s.findUnsortedSubarray(new int[]{2, 6, 8, 4, 9, 15}));
        Utils.print(s.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        Utils.print(s.findUnsortedSubarray(new int[]{1}));
        Utils.print(s.findUnsortedSubarray(new int[]{2, 1}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int high = 0;
        for (int i = 1; i < n; i++) {
            if (max > nums[i]) {
                high = i;
            }
            max = Math.max(max, nums[i]);
        }
        int min = nums[n - 1];
        int low = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (min < nums[i]) {
                low = i;
            }
            min = Math.min(min, nums[i]);
        }
        return high > low ? high - low + 1 : 0;
    }
}
