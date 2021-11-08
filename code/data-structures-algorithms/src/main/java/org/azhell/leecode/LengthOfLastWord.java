package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 58. 最后一个单词的长度
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Utils.print(new LengthOfLastWord().lengthOfLastWord("Hello World"));
        Utils.print(new LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  "));
        Utils.print(new LengthOfLastWord().lengthOfLastWord("luffy is still joyboy"));
        Utils.print(new LengthOfLastWord().lengthOfLastWord("a"));
    }

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int start = chars.length - 1;
        int end = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                start--;
            } else {
                if (end == start) {
                    end--;
                    start--;
                } else {
                    break;
                }
            }
        }
        return end - start;
    }
}
