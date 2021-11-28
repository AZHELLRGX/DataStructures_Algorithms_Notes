package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 滑动窗口
 * 20211128  目前对滑动窗口的运用还不是很熟悉，等以后题目写多了再回来优化
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        Utils.print(findAllAnagramsInAString.findAnagrams("cbaebabacd","abc"));
        Utils.print(findAllAnagramsInAString.findAnagrams("abab","ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return result;
        }

        int[] sCnt = new int[26];
        int[] pCnt = new int[26];

        for (int i = 0; i < n; i++) {
            pCnt[p.charAt(i) - 'a'] += 1;
            sCnt[s.charAt(i) - 'a'] += 1;
        }
        // 初始窗口是否相同
        if (Arrays.equals(pCnt, sCnt)) {
            result.add(0);
        }
        // 开始滑动窗口
        for (int i = 0; i < m - n; i++) {
            sCnt[s.charAt(i) - 'a'] -= 1;
            sCnt[s.charAt(i + n) - 'a'] += 1;
            if (Arrays.equals(pCnt, sCnt)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
