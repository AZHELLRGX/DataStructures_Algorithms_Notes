package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1716. 计算力扣银行的钱
 */
public class CalculateMoneyInLeetcodeBank {
    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank c = new CalculateMoneyInLeetcodeBank();
        Utils.print(c.totalMoney(4));
    }

    public int totalMoney(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++)
            s += (i - 1) / 7 + (i - 1) % 7 + 1;
        return s;
    }
}
