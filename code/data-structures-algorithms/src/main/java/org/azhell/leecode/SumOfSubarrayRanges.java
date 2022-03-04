package org.azhell.leecode;

import org.azhell.tool.Utils;


/**
 * 2104. 子数组范围和
 * 直接暴力解了
 */
public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        SumOfSubarrayRanges s = new SumOfSubarrayRanges();
        Utils.print(s.subArrayRanges(new int[]{1, 2, 3}));
        Utils.print(s.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }

    public long subArrayRanges(int[] nums) {
        final int len = nums.length;
        long ans = 0L;
        for (int i = 0; i < len; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

}
