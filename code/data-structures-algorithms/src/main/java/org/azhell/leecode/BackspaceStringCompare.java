package org.azhell.leecode;


import org.azhell.tool.Utils;

/**
 * 844. 比较含退格的字符串
 * 栈可以解决，也比较简单
 * 但是空间复杂度仍旧较高，可以使用双指针解答
 * <p>
 * 本题的难点主要是倒叙遍历字符串，不是正序
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        Utils.print(b.backspaceCompare("ab#c", "ad#c"));
        Utils.print(b.backspaceCompare("ab##", "c#d#"));
        Utils.print(b.backspaceCompare("a##c", "#a#c"));
        Utils.print(b.backspaceCompare("a#c", "b"));
        Utils.print(b.backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }

    public boolean backspaceCompare(String s, String t) {
        // 对两个字符串中的“#”进行计数
        int skipS = 0;
        int skipT = 0;
        // 字符串的两个指针
        int sPoint = s.length() - 1;
        int tPoint = t.length() - 1;
        while (sPoint >= 0 || tPoint >= 0) {
            char sChar = sPoint >= 0 ? s.charAt(sPoint--) : ' ';
            while (sPoint >= 0) {
                if (sChar == '#') {
                    skipS += 1;
                } else if (skipS != 0) {
                    skipS -= 1;
                } else {
                    break;
                }
                sChar = s.charAt(sPoint--);
            }
            if (skipS != 0 || sChar == '#') sChar = ' ';
            char tChar = tPoint >= 0 ? t.charAt(tPoint--) : ' ';
            while (tPoint >= 0) {
                if (tChar == '#') {
                    skipT += 1;
                } else if (skipT != 0) {
                    skipT -= 1;
                } else {
                    break;
                }
                tChar = t.charAt(tPoint--);
            }
            if (skipT != 0 || tChar == '#') tChar = ' ';
            if (sChar != tChar) {
                return false;
            }
        }
        return sPoint == tPoint;
    }
}
