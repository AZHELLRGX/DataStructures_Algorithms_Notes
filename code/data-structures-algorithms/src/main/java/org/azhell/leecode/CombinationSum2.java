package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和2
 * 加了一个结果集不允许重复数据的限制
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        Utils.print(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        Utils.print(new CombinationSum2().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHandle(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void combinationSumHandle(int[] candidates, int target, int j, List<Integer> solution) {
        // 确定结束条件
        if (target == 0) {
            // 一定要重新创建集合
            result.add(new ArrayList<>(solution));
        }
        // 剪枝优化
        int previousCandidate = 0;
        for (int i = j; i < candidates.length; i++) {
            if (target - candidates[i] >= 0 && candidates[i] != previousCandidate) {
                solution.add(candidates[i]);
                previousCandidate = candidates[i];
                combinationSumHandle(candidates, target - candidates[i], i + 1, solution);
                // 回退
                solution.remove(solution.size() - 1);
            }
        }
    }
}
