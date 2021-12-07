package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1816. 截断句子
 * 目前做过最简单的一道题
 */
public class TruncateSentence {
    public static void main(String[] args) {
        TruncateSentence t = new TruncateSentence();
        Utils.print(t.truncateSentence("Hello how are you Contestant", 4));
        Utils.print(t.truncateSentence("What is the solution to this problem", 4));
        Utils.print(t.truncateSentence("chopper is not a tanuki", 5));
    }

    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && --k == 0) {
                return s.substring(0, i);
            }
        }
        return s;
    }
}
