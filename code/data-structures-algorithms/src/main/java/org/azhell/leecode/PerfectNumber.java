package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 507. 完美数
 * 利用完美数的性质暴力解了
 */
public class PerfectNumber {
    public static void main(String[] args) {
        PerfectNumber p = new PerfectNumber();
        Utils.print(p.checkPerfectNumber(28));
        Utils.print(p.checkPerfectNumber(6));
        Utils.print(p.checkPerfectNumber(496));
        Utils.print(p.checkPerfectNumber(8192));
        Utils.print(p.checkPerfectNumber(8128));
        Utils.print(p.checkPerfectNumber(1));
    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        } else {
            int sum = 0;
            for (int i = 1; i < num - 1; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            return sum == num;
        }
    }
}
