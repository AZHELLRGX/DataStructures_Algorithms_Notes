package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 137. 只出现一次的数字 II
 * 位运算
 */
public class Q137 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 2};
        Utils.print(new Q137().singleNumber(nums));
        nums = new int[]{0, 1, 0, 1, 0, 1, 99};
        Utils.print(new Q137().singleNumber(nums));
    }


    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 != 0) {
                // 将1左移动i位，也就是在ans的i（从右往左）位置设置1
                ans |= 1 << i;
            }
        }
        return ans;
    }
}