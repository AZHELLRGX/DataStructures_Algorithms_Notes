package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 139. 单词拆分
 * 到n位的单词可以被拆分，依赖的是[1,x]为true且[x,n]可以在单词列表中找到
 * x是一个指针，一步步的指向后续的字母
 * 本题和官方题解的思路大致一致
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        Utils.print(w.wordBreak("leetcode", Arrays.asList("leet", "code")));
        Utils.print(w.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        Utils.print(w.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Utils.print(w.wordBreak("a", Collections.singletonList("a")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // 为了方便检索
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // 记录为true的位置
        List<Integer> trueList = new ArrayList<>();
        trueList.add(-1);
        for (int i = 0; i < s.length(); i++) {
            for (Integer index : trueList) {
                // subString的效率还是有点低
                final String substring = s.substring(index + 1, i + 1);
                if (wordDictSet.contains(substring)) {
                    if (i == s.length() - 1) {
                        return true;
                    }
                    trueList.add(i);
                    break;
                }
            }
        }
        return false;
    }
}
