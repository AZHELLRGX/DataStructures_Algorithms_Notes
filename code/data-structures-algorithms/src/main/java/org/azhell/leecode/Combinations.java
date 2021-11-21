package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 回溯法 + 剪枝优化
 */
public class Combinations {
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        Utils.print(combinations.combine(4, 2));
        combinations.result = new ArrayList<>();
        Utils.print(combinations.combine(1, 1));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(n + 1, 1, k, new ArrayList<>(k));
        return result;
    }

    private void combine(int n, int j, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = j; i < n; i++) {
                list.add(i);
                combine(n, i + 1, k, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
