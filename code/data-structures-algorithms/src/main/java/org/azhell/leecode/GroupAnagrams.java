package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 字母异位词分组
 * hash表
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Utils.print(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        Utils.print(new GroupAnagrams().groupAnagrams(new String[]{""}));
        Utils.print(new GroupAnagrams().groupAnagrams(new String[]{"a"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
