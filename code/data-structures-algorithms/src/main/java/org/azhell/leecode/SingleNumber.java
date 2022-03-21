package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 136. 只出现一次的数字
 * 异或运算
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        Utils.print(s.singleNumber(new int[]{2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
