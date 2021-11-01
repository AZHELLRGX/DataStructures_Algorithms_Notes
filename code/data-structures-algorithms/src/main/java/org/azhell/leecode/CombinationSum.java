package org.azhell.leecode;


import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 本来开始尝试动态规划解题
 * 但是好像都建议回溯算法
 * 需要思考结果重复的问题如何解决
 */
public class CombinationSum {
    public static void main(String[] args) {
        Utils.print(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        Utils.print(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
        Utils.print(new CombinationSum().combinationSum(new int[]{2}, 1));
        Utils.print(new CombinationSum().combinationSum(new int[]{1}, 1));
        Utils.print(new CombinationSum().combinationSum(new int[]{1}, 2));
        Utils.print(new CombinationSum().combinationSum(new int[]{2, 1}, 4));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            if (target - candidate >= 0) {
                List<Integer> solution = new ArrayList<>();
                solution.add(candidate);
                combinationSumHandle(candidates, candidate, target - candidate, solution);
            }
        }
        return result;
    }

    public void combinationSumHandle(int[] candidates, int previousNum, int target, List<Integer> solution) {
        // 确定结束条件
        if (target == 0) {
            // 一定要重新创建集合
            result.add(new ArrayList<>(solution));
        }
        // 剪枝优化
        int previousCandidate = 0;
        for (int candidate : candidates) {
            if (target - candidate >= 0 && candidate != previousCandidate && candidate <= previousNum) {
                solution.add(candidate);
                previousCandidate = candidate;
                combinationSumHandle(candidates, candidate, target - candidate, solution);
                // 回退
                solution.remove(solution.size() - 1);
            }
        }
    }
}
