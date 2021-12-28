package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. 实现 Trie (前缀树)
 * 目前使用的方式是直接使用hash表构建一个链路，节点的唯一end属性表示是否在当前节点存在截止单词
 */
public class ImplementTrieAliasPrefixTree {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        Utils.print(t.search("applee"));
        Utils.print(t.search("app"));
        Utils.print(t.startsWith("app"));
        t.insert("app");
        Utils.print(t.search("app"));
        Utils.print(t.search("apple"));
    }

    static class Trie {

        // 是否是单词结尾
        boolean end;
        // 这里根本就没有存储当前节点的数据
        // 子节点
        Map<Character, Trie> children;

        public Trie() {
            this(false);
        }

        public Trie(boolean end) {
            this.end = end;
            // 子节点的数量只能孩子节点来声明
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            Trie t = this;
            final char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                // 判断当前节点的children是否存在对应的字符;没有就新建然后放入map
                t.children.putIfAbsent(chars[i], new Trie(false));
                // 判断是否是最后一个
                if (i == chars.length - 1) {
                    t.children.get(chars[i]).end = true;
                }
                // 有就更新节点，开始查找下一个
                t = t.children.get(chars[i]);
            }
        }

        public boolean search(String word) {
            final char[] chars = word.toCharArray();
            Trie t = this.children.get(chars[0]);
            for (int i = 0; i < chars.length; i++) {
                if (t != null) {
                    if (i == chars.length - 1) {
                        return t.end;
                    } else {
                        t = t.children.get(chars[i + 1]);
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        public boolean startsWith(String prefix) {
            final char[] chars = prefix.toCharArray();
            Trie t = this.children.get(chars[0]);
            for (int i = 0; i < chars.length; i++) {
                if (t != null) {
                    if (i == chars.length - 1) {
                        return true;
                    } else {
                        t = t.children.get(chars[i + 1]);
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        // 可能因为这里的delete操作有难度，所以力扣并未考察
        /*
         * 但是这里可以预留一下删除的逻辑描述，分为以下三种情况：
         * word在list中不存在，直接返回失败
         * word最后一个char 没有child，则删掉此节点并朝 root 查找没有child && isEnd=false 的节点都删掉
         * word最后一个char 有child，则把isEnd置为false
         */
    }

}
