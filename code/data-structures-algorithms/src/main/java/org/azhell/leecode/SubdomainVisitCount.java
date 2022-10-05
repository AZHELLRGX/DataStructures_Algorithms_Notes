package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 811. 子域名访问计数
 * 2022年国庆期间的题目还是比较简单的
 */
public class SubdomainVisitCount {
    public static void main(String[] args) {
        SubdomainVisitCount s = new SubdomainVisitCount();
        Utils.print(s.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        Utils.print(s.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] array = cpdomain.split(" ");
            int count = Integer.parseInt(array[0]);
            String[] domains = array[1].split("\\.");
            StringBuilder suffix = new StringBuilder();
            for (int i = domains.length - 1; i >= 0; i--) {
                String s = domains[i] + suffix;
                map.put(s, map.computeIfAbsent(s, key -> 0) + count);
                suffix.insert(0, "." + domains[i]);
            }
        }
        List<String> result = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
