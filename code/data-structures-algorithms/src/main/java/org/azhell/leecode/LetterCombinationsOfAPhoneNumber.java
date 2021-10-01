package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 电话号码的字母组合
 * 回溯算法
 * 关于回溯算法：这篇文章解释的不错
 * https://zhuanlan.zhihu.com/p/93530380
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Utils.print(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
        Utils.print(new LetterCombinationsOfAPhoneNumber().letterCombinations(""));
    }

    List<String> result = new ArrayList<>();
    Map<String, String[]> map = new HashMap<String, String[]>() {{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return result;
        backtrack("", Arrays.asList(digits.split("")));
        return result;
    }

    private void backtrack(String path, List<String> digitList) {
        if (digitList.isEmpty()) {
            result.add(path);
        } else {
            for (String s : map.get(digitList.get(0))) {
                backtrack(path + s, digitList.subList(1, digitList.size()));
            }
        }
    }

}
