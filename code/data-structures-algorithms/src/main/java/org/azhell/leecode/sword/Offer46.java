package org.azhell.leecode.sword;


import org.azhell.tool.Utils;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 动态规划
 * f(0) = 1
 * f(1) = f(0) + 1(如果两位数小于26的话)
 * f(2) = f(1) + f(0)(如果两位数小于26的话)
 * f(i) = f(i-1) + f(i-2)(如果两位数小于26的话)
 */
public class Offer46 {
    public static void main(String[] args) {
        Offer46 o = new Offer46();
        Utils.print(o.translateNum(12258));
        Utils.print(o.translateNum(26));
        Utils.print(o.translateNum(506));
    }

    public int translateNum(int num) {
        // 转成字符串更好处理
        final String s = String.valueOf(num);
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = dp[i - 1];
            final char pre = s.charAt(i - 1);
            final char cur = s.charAt(i);
            if (pre == '1' || (pre == '2' && cur <= '5')) {
                if (i > 1)
                    dp[i] += dp[i - 2];
                else
                    dp[i] += 1;
            }
        }
        return dp[s.length() - 1];
    }
}
