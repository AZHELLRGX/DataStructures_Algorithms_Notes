package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * todo 这道题先背下来吧
 * ^ 异或运算 相当于无进位的求和
 * & 与运算 想当然求进位
 * 这样结合二者可以得出公式 ：(a^b) ^ ((a&b)<<1)
 */
public class Offer65 {
    public static void main(String[] args) {
        Offer65 o = new Offer65();
        Utils.print(o.add(1, 1));
        Utils.print(o.add(3, 4));
    }

    public int add(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        // 记住递归公式即可
        return add((a ^ b), ((a & b) << 1));
    }
}
