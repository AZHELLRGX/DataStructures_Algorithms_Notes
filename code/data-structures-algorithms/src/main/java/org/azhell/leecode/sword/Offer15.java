package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 15. 二进制中1的个数
 */
public class Offer15 {
    public static void main(String[] args) {
        Offer15 o = new Offer15();
        Utils.print(o.hammingWeight(11));
        Utils.print(o.hammingWeight(128));
        Utils.print(o.hammingWeight(-3));
    }

    public int hammingWeight(int n) {
        // 直接进行无符号位运算，Java中，n最大为32位
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
