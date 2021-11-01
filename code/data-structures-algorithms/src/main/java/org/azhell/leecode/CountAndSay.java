package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 外观数列
 * 一个简单递归解决
 * 难点在于读懂题目哈哈哈
 */
public class CountAndSay {
    public static void main(String[] args) {
        Utils.print(new CountAndSay().countAndSay(16));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            // 直接从第二层开始，所以是n-1
            return countAndSayHandle("1", 0, n - 1);
        }
    }

    public String countAndSayHandle(String lastSay, int c, int n) {
        if (c == n) {
            return lastSay;
        } else {
            // 开始对lastSay计数
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char curChar = lastSay.charAt(0);
            for (int i = 1; i < lastSay.length(); i++) {
                if (curChar == lastSay.charAt(i)) {
                    count++;
                } else {
                    // 保存计数
                    sb.append(count).append(curChar);
                    curChar = lastSay.charAt(i);
                    count = 1;
                }
            }
            sb.append(count).append(curChar);
            return countAndSayHandle(sb.toString(), ++c, n);
        }
    }
}
