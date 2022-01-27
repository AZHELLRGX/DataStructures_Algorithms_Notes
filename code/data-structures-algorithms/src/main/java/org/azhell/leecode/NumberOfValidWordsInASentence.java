package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 2047. 句子中的有效单词数
 * 1、遇到数字false
 * 2、遇到标点，不在末尾false
 * 3、连字符 左右两侧都是小写字母
 * 4、标点或者连字符出现多次false
 */
public class NumberOfValidWordsInASentence {
    public static void main(String[] args) {
        NumberOfValidWordsInASentence n = new NumberOfValidWordsInASentence();
        Utils.print(n.countValidWords("cat and  dog"));
        Utils.print(n.countValidWords("!this  1-s b8d!"));
        Utils.print(n.countValidWords("alice and  bob are playing stone-game10"));
        Utils.print(n.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

    public int countValidWords(String sentence) {
        final String[] array = sentence.split(" ");
        int cnt = 0;
        for (String s : array) {
            if (!s.isEmpty() && isValid(s)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private boolean isValid(String s) {
        boolean hasHyphen = false;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                return false;
            } else if ((c == '!' || c == '.' || c == ',') && i != s.length() - 1) {
                return false;
            } else if (c == '-') {
                if (hasHyphen)
                    return false;
                else if (i - 1 < 0 || isNotLetter(s.charAt(i - 1))
                        || i + 1 >= s.length() || isNotLetter(s.charAt(i + 1))) {
                    return false;
                }
                hasHyphen = true;
            }
        }
        return true;
    }

    private boolean isNotLetter(char c) {
        return c > 'z' || c < 'a';
    }
}
