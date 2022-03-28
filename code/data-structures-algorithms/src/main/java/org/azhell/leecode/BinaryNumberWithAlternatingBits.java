package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 693. 交替位二进制数
 * 经典位运算题目
 * 异或解决
 */
public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits b = new BinaryNumberWithAlternatingBits();
        Utils.print(b.hasAlternatingBits(5));
        Utils.print(b.hasAlternatingBits(7));
        Utils.print(b.hasAlternatingBits(11));
    }

    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
