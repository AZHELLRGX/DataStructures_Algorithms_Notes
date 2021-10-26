package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 * 哈希表和滑动窗口
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Utils.print(new SubstringWithConcatenationOfAllWords().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        Utils.print(new SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        Utils.print(new SubstringWithConcatenationOfAllWords().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        Utils.print(new SubstringWithConcatenationOfAllWords().findSubstring("aaa", new String[]{"a", "a"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        Map<String, Integer> originMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();

        for (String word : words) {
            Integer count = originMap.computeIfAbsent(word, key -> 0) + 1;
            originMap.put(word, count);
        }
        // 开始滑动字符串
        int wordLen = words[0].length();
        int wordCount = words.length;
        int allWordLen = wordLen * wordCount;
        for (int i = 0; i < s.length(); i++) {
            if (i + allWordLen > s.length()) {
                break;
            }
            int j = i;
            // 从j开始，wordLen个数据切一段
            for (int k = 0; k < wordCount; k++) {
                String subWord = s.substring(j, j + wordLen);
                if (!originMap.containsKey(subWord) || (resultMap.containsKey(subWord) && resultMap.get(subWord) + 1 > originMap.get(subWord))) {
                    resultMap.clear();
                    break;
                } else if (k == wordCount - 1) {
                    // 满足条件
                    resultList.add(j - k * wordLen);
                    resultMap.clear();
                } else {
                    Integer count = resultMap.computeIfAbsent(subWord, key -> 0);
                    resultMap.put(subWord, count + 1);
                    j = j + wordLen;
                }

            }
        }
        return resultList;
    }
}
