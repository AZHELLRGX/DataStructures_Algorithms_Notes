package org.azhell.lanqiao;

import org.azhell.tool.Utils;

/*
 * 二进制数中1的个数
 * 例如数字9对应的二进制数是1001,它的二进制数中1的个数就是2
 * 解法1：不断的和1、2、4、8等数据进行与运算，比如1001与1000与的时候，结果就是1000；
 *      就表示这个位置有一个1；其实这个方法可以直接拿来做除法也可以
 * 解法2：数值不断进行减一操作，然后与原数据进行与运算；
 *
 * 这道题可以衍生出另外一道题：用一条语句判断一个整数是不是2的整数次方
 * if((n & (n-1)) == 0)
 */
public class NumOneInBinary {
    public static void main(String[] args) {
        int n = 999;

        int count = 0;
        for (int i = 0; i < 32; i++) {
            // 左移写法
            if ((n & (1 << i)) == (1 << i)) {
                count++;
            }
            // 1不动，数据不断的右移
//            if (((n >>> i) & 1) == 1) {
//                count++;
//            }
        }
        Utils.print(n + "的二机制数为" + Integer.toBinaryString(n) + "；其中1的个数为" + count);
        Utils.print("---------------------");
        // 上面与运算的变种；除法运算；但是性能可能稍差
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


        count = 0;
        while (n != 0){
            n = n & (n-1);
            count++;
        }
        n = 999;
        Utils.print(n + "的二机制数为" + Integer.toBinaryString(n) + "；其中1的个数为" + count);
    }
}
