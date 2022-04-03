package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 744. 寻找比目标字母大的最小字母
 * 这道题的难点在于要理解题意：
 * 如果在字母序列中找不到比目标字母大的，则返回序列的第一个元素
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget f = new FindSmallestLetterGreaterThanTarget();
        Utils.print(f.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        Utils.print(f.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'z'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }
}
