package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 121. 买卖股票的最佳时机
 */
public class Offer63 {
    public static void main(String[] args) {
        Offer63 o = new Offer63();
        Utils.print(o.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Utils.print(o.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
