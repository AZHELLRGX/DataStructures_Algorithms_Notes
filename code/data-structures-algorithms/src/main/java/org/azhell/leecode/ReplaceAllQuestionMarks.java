package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Random;

/**
 * 1576. 替换所有的问号
 * 其实本题还可以使用另外一种思路，只需要三个任意字母就够了，遇到？从三个字母中选取即可
 */
public class ReplaceAllQuestionMarks {
    public static void main(String[] args) {
        ReplaceAllQuestionMarks r = new ReplaceAllQuestionMarks();
        Utils.print(r.modifyString("?zs"));
        Utils.print(r.modifyString("ubv?w"));
        Utils.print(r.modifyString("j?qg??b"));
        Utils.print(r.modifyString("??yw?ipkj?"));
        Utils.print(r.modifyString("?"));
        Utils.print(r.modifyString("????"));
    }

    public String modifyString(String s) {
        final char[] chars = s.toCharArray();
        final int length = s.length();
        // a - z 97-122
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '?') {
                int a = r.nextInt(26) + 97;
                // 判断左侧字符和右侧字符
                if (i > 0 && i < length - 1) {
                    // 随机值
                    while (a == chars[i - 1] || a == chars[i + 1]) {
                        a = r.nextInt(26) + 97;
                    }
                } else if (i == 0 && i != length - 1) {
                    while (a == chars[i + 1]) {
                        a = r.nextInt(26) + 97;
                    }
                } else if (i != 0 && i == length - 1) {
                    while (a == chars[i - 1]) {
                        a = r.nextInt(26) + 97;
                    }
                }
                chars[i] = (char) a;
            }
        }
        return new String(chars);
    }
}
