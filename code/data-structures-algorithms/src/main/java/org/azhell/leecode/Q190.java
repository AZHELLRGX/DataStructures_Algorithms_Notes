package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 190. 颠倒二进制位
 */
public class Q190 {
    public static void main(String[] args) {
        int n = -3;
        Utils.print(new Q190().reverseBits(n));
    }

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int num = (n >> i) & 1;
            ans |= num << (31 - i);
        }
        return ans;
    }
}
