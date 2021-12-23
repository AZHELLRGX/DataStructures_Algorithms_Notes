package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * 做这题的目的是为了熟悉一下滚动hash算法 + 前缀和思想
 * <p>
 * 前缀和指一个数组的某下标之前的所有数组元素的和（包含其自身）。
 * 前缀和分为一维前缀和，以及二维前缀和。前缀和是一种重要的预处理，能够降低算法的时间复杂度。
 * [i, j]的区间和公式: interval [i, j] = sum[j] - sum[i - 1]
 * 一维前缀和的公式：sum[i] = sum[i-1] + arr[i]
 * <p>
 * hash可以帮助加快检索
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        RepeatedDNASequences r = new RepeatedDNASequences();
        Utils.print(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        Utils.print(r.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        final int Q = 131313; // 加盐避免hash冲突
        int[] p = new int[n + 1]; // 前缀和数组
        int q = 1;
        for (int i = 1; i <= n; i++) {
            // 计算一维前缀和
            p[i] = p[i - 1] * Q + s.charAt(i - 1);
            if (i <= 10)
                q *= Q;
        }
        List<String> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 10个字符一组遍历字符串
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            // [i, j]的区间和
            int hash;
            hash = p[j] - p[i - 1] * q;

            final Integer count = map.getOrDefault(hash, 0);
            if (count == 1) {
                ans.add(s.substring(i - 1, j));
            }
            map.put(hash, count + 1);
        }
        return ans;
    }
}
