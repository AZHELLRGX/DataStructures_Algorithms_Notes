package org.azhell.lanqiao;

import org.azhell.tool.Utils;

/*
 * 二进制数中1的个数
 * 例如数字9对应的二进制数是1001,它的二进制数中1的个数就是2
 * 解法1：不断的和1、2、4、8等数据进行与运算，比如1001与1000与的时候，结果就是1000；
 *      就表示这个位置有一个1；其实这个方法可以直接拿来做除法也可以
 * 解法2：
 */
public class NumOneInBinary {
    public static void main(String[] args) {
        int n = 999;

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == (1 << i)) {
                count++;
            }
        }
        Utils.print(n + "的二机制数为" + Integer.toBinaryString(n) + "；其中1的个数为" + count);
        Utils.print("---------------------");
        // 上面与运算的变种
        count = 0;
        for (int i = 31; i >= 0; i--) {
            int temp = n;
            n = n % (1 << i);
            if (n != temp) {
                count++;
            }
        }
        n = 999;
        Utils.print(n + "的二机制数为" + Integer.toBinaryString(n) + "；其中1的个数为" + count);

    }
}
