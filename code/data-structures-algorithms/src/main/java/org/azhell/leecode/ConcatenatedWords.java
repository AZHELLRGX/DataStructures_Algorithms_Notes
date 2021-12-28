package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 472. 连接词
 * 前缀树 + DFS
 * 前缀树208题可以完成，但是本题的DFS 和 记忆化搜索才是难点
 * todo 未来需要回来重看的代码
 */
public class ConcatenatedWords {
    public static void main(String[] args) {
        ConcatenatedWords c = new ConcatenatedWords();
        Utils.print(c.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
        Utils.print(c.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"}));
    }

    static class PrefixTree {
        final PrefixTree[] next = new PrefixTree[26];
        boolean end = false;

        // debug
        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (next[i] != null)
                    s.append((char) ('a' + i)).append(";");
            }
            return s.toString();
        }
    }


    PrefixTree prefixTree;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        prefixTree = new PrefixTree();
        List<String> result = new LinkedList<>();
        for (String word : words) {
            Boolean[] memory = new Boolean[word.length()];
            if (!word.isEmpty() && dfs(word, 0, prefixTree, 1, memory)) {
                result.add(word);
            }
            insert(word);
        }
        return result;
    }

    public void insert(String word) {
        int wordLength = word.length();
        PrefixTree cur = prefixTree;
        for (int i = 0; i < wordLength; i++) {
            int index = word.charAt(i) - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new PrefixTree();
            }
            cur = cur.next[index];
        }
        cur.end = true;
    }

    private boolean dfs(String word, int index, PrefixTree cur, int whichWord, Boolean[] memory) {
        // 获取当前节点
        cur = cur.next[word.charAt(index) - 'a'];
        // 已经遍历到最后
        if (index == word.length() - 1) {
            return cur != null && cur.end && whichWord > 1;
        } else if (cur == null) {
            return false;
        }
        // 已经检索到一个单词，而且这个单词也是一个连接词
        if (cur.end && memory[index] != null) {
            return memory[index];
        }
        /*
         * 两种情况：
         * 1、已经找到一个单词，从前缀树开始节点重新判断剩下部分的字母是否是一个连接词
         * 2、没找到单词，继续往下找下一个字母
         */
        boolean flag = (cur.end && dfs(word, index + 1, prefixTree, whichWord + 1, memory) || dfs(word, index + 1, cur, whichWord, memory));
        // 如果当前节点存在单词
        if (cur.end) {
            memory[index] = flag;
        }
        return flag;
    }

}
