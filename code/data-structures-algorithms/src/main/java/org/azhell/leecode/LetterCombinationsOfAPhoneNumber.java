package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 17.电话号码的字母组合
 * 回溯算法
 * 关于回溯算法：这篇文章解释的不错
 * https://zhuanlan.zhihu.com/p/93530380
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Utils.print(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
        Utils.print(new LetterCombinationsOfAPhoneNumber().letterCombinations(""));
    }

    List<String> result;
    Map<Character, char[]> map = new HashMap<Character, char[]>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {
        this.result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        char[] array = new char[digits.length()];
        backtrack(array, 0, digits);
        return result;
    }

    private void backtrack(char[] array, int i, String digits) {
        if (i == digits.length()) {
            result.add(new String(array));
        } else {
            char[] chars = map.get(digits.charAt(i));
            for (char c : chars) {
                array[i] = c;
                backtrack(array, i + 1, digits);
            }
        }
    }

}
