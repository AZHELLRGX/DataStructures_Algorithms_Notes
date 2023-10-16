package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 260. 只出现一次的数字 III
 */
public class Q260 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        Utils.print(new Q260().singleNumber(nums));
    }

    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        int lsb;
        if (xorsum == Integer.MIN_VALUE) {
            // 最高位是1，它的相反数会溢出
            // 此时也可以确定只有一个1
            lsb = xorsum;
        } else {
            lsb = xorsum & -xorsum;
        }
        // 保证lsb的二进制中只有一个1
        // 可以证明不同的两个数的二进制在这个1的位置，一定有一个是1，一个是0
        // 而其他数据，要么是0，要么是1，但是因为出现两次，所以异或后的结果仍然是0
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & lsb) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
