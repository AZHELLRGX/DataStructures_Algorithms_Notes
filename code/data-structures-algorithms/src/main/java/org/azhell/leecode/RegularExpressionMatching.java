package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 动态规划解决正则匹配问题
 * todo 还未解决，后续操作
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        Utils.print(isMatch0("aadafgdsgfdgdf", "aadafgdsgfdgff"));
        Utils.print(isMatch1("aadafgdsgfdgdf", "aadafgd.gfdg.f"));
        // 暂时不解了，目前这个测试用例过不了"aaa"、"ab*a*c*a"
        Utils.print(isMatch2("aaa", "aaaa"));
    }

    // 先实现一个判断两个字符串是否相等的方法（使用递归，不借助equals方法）
    private static boolean isMatch0(String s, String p) {
        if (s.length() != p.length()) return false;
        if (s.length() == 0) return true;
        if (s.charAt(0) != p.charAt(0)) {
            return false;
        } else {
            return isMatch0(s.substring(1), p.substring(1));
        }
    }

    // 加入.号参与匹配
    private static boolean isMatch1(String s, String p) {
        if (s.length() != p.length()) return false;
        if (s.length() == 0) return true;
        if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
            return false;
        } else {
            return isMatch1(s.substring(1), p.substring(1));
        }
    }

    // 加入*号  参考示例：s = "aab" p = "c*a*b"
    private static boolean isMatch2(String s, String p) {
        // 如果匹配字符串为空，判断s是否为空
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return false;
        }
        // 如果出现了*号
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 两种情况：* 匹配0次和多次
            char c = s.charAt(0);
            if (c != p.charAt(0) && p.charAt(0) != '.') {
                return isMatch2(s, p.substring(2));
            } else if (p.charAt(0) == '.') {
                // .*匹配无限个字符,需要从*位置后面截断字符
                int index = p.indexOf(".*") + 2;
                // 如果已经是最后一位
                if (index == p.length()) {
                    return true;
                }
                char nc = p.charAt(index);
                // 否则继续往后匹配
                // 需要逐步检测s重复了多少位数据
                int index1 = s.length();
                for (int i = 1; i < s.length(); i++) {
                    if (nc == s.charAt(i)) {
                        index1 = i;
                        break;
                    }
                }
                if (index1 == s.length()) {
                    return false;
                }
                return isMatch2(s.substring(index1), p.substring(index));
            } else {
                // 需要逐步检测s重复了多少位数据
                int index = 1;
                for (int i = 1; i < s.length(); i++) {
                    if (c != s.charAt(i)) {
                        index = i;
                        break;
                    }
                }
                // aa 与 a*
                if (c == s.charAt(index)) {
                    index += 1;
                }
                return isMatch2(s.substring(index), p.substring(2));
            }
        } else {
            if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
                return false;
            } else {
                return isMatch2(s.substring(1), p.substring(1));
            }
        }
    }
}
