package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 2562. 找出数组的串联值
 */
public class Q2562 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 14, 13, 8, 12};
        Utils.print(new Q2562().findTheArrayConcVal(nums));
    }

    public long findTheArrayConcVal(int[] nums) {
        long result = 0L;
        int last = nums.length;
        for (int i = 0; i < nums.length / 2; i++) {
            last -= 1;
            result += Long.parseLong(Integer.toString(nums[i]) + nums[last]);
        }
        if (nums.length % 2 == 1) {
            result += nums[nums.length / 2];
        }
        return result;
    }
}
