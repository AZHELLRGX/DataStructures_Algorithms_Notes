package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.无重复字符的最长子串
 * 最开始的代码效率很差，看到别人使用队列解题的思路，我也来试试
 * 这种题的解决思路其实就是使用一个滑动窗口
 * 在java里面可以使用Map来做滑动窗口
 * <p>
 * 收藏一个很牛的解法，属于把数组运用到极致了，这也给了我启发，
 * 数组的下标不只是可以拿来做元素的索引而已
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abba";
        Utils.print(lengthOfLongestSubstring(s));
        Utils.print(lengthOfLongestSubstring1(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int left = 0; // 用来记录左侧最近的没有重复字符的起点
        int max = 0; // 用来记录最长子字符串
        // 不重复字符最新的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 判断右侧字符是否已经与左侧现有字符相同
            if (map.containsKey(c)) {
                // 出现了重复字符，数据就要从曾经出现过此字符的地方截断重新开始计算长度
                // 必须需要使用max函数，避免类似abba这种情况出现，left只能右移，不能左移
                left = Math.max(map.get(c) + 1, left);
            }
            // 不断的更新字符串在相同字符的最新位置
            map.put(c, i);
            // 判断最新的子字符串长度是否已经大于历史
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


    private static int lengthOfLongestSubstring1(String s) {
        // 记录字符上一次出现的位置
        // 数组的下标是字符的ASCII码值，而数组的值则是元素的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
