package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 */
public class Offer50 {
    public static void main(String[] args) {
        Offer50 o = new Offer50();
        Utils.print(o.firstUniqChar("abaccdeff"));
        Utils.print(o.firstUniqChar(""));
        Utils.print(o.firstUniqChar("leetcode"));
        Utils.print(o.firstUniqChar("z"));
    }

    public char firstUniqChar(String s) {
        // 使用字典记录出现的次数以及位置，出现第二次将值置为-1
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (arr[c] == 0) {
                // 规避索引也是0的情况
                arr[c] = i + 1;
            } else {
                arr[c] = -1;
            }
        }
        // 因为前面的索引都+1，所以这里最大索引值也+1
        int minIndex = s.length() + 1;
        char firstOneChar = ' ';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && minIndex > arr[i]) {
                firstOneChar = (char) (i + 'a');
                minIndex = arr[i];
            }
        }
        return firstOneChar;
    }
}
