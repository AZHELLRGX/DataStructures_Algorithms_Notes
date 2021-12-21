package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 91. 解码方法
 * 动态规划
 * 效率有点差，多半是字符串处理上的问题
 */
public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        Utils.print(d.numDecodings("11106"));
        Utils.print(d.numDecodings("12"));
        Utils.print(d.numDecodings("226"));
        Utils.print(d.numDecodings("123123"));
        Utils.print(d.numDecodings("0"));
        Utils.print(d.numDecodings("06"));
        Utils.print(d.numDecodings("111111111111111111111111111111111111111111111"));
        Utils.print(d.numDecodings("230"));
        Utils.print(d.numDecodings("27"));
        Utils.print(d.numDecodings("10"));
    }

    public int numDecodings(String s) {
        if (s.length() == 1) {
            return "0".equals(s) ? 0 : 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = getNum(s.substring(s.length() - 1));
        dp[1] = getNum(s.substring(s.length() - 2));
        if (s.length() > 2) {
            int i = 2;
            while (i < s.length()) {
                String s1 = s.substring(s.length() - i - 1, s.length() - i + 1);
                String s2 = s.substring(s.length() - i - 1, s.length() - i);
                dp[i] = valid(s1) * dp[i - 2] +
                        valid(s2) * dp[i - 1];
                i++;
            }
        }
        return dp[s.length() - 1];
    }

    private int valid(String s) {
        if (s.startsWith("0")) {
            return 0;
        } else {
            if (s.length() == 1) {
                return 1;
            } else {
                int i = Integer.parseInt(s);
                return i <= 26 ? 1 : 0;
            }
        }
    }

    private int getNum(String s) {
        if (s.length() == 1) {
            if (s.equals("0")) {
                return 0;
            } else {
                return 1;
            }
        } else if (s.length() == 2) {
            if (s.startsWith("0")) {
                return 0;
            } else {
                int i = Integer.parseInt(s);
                if (i > 10 && i != 20 && i <= 26) {
                    return 2;
                } else if (i == 10 || i == 20 || !s.contains("0")) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }
}
