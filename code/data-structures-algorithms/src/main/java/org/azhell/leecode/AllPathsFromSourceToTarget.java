package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 797. 所有可能的路径
 * 深度优先搜索
 * DFS一般与栈结合使用，类似回溯算法
 * 因为题目已经告知了给的图是有向无环图，所以不需要记录已经遍历过的节点
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        AllPathsFromSourceToTarget a = new AllPathsFromSourceToTarget();
        Utils.print(a.allPathsSourceTarget(new int[][]{
                {1, 2}, {3}, {3}, {}
        }));
        Utils.print(a.allPathsSourceTarget(new int[][]{
                {4, 3, 1}, {3, 2, 4}, {3}, {4}, {}
        }));
    }

    List<List<Integer>> result;
    Deque<Integer> stack;
    int n;
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        this.result = new ArrayList<>();
        this.stack = new ArrayDeque<>();
        stack.offerLast(0);
        dfs(0);
        return result;
    }

    private void dfs(int x) {
        if (x == n - 1) {
            result.add(new ArrayList<>(stack));
        } else {
            int[] array = graph[x];
            for (int i : array) {
                stack.offerLast(i);
                dfs(i);
                stack.pollLast();
            }
        }
    }
}
