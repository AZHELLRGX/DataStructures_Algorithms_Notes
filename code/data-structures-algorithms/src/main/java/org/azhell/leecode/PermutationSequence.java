package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 60. 排列序列
 * 其实就是深度优先遍历思想 但是难点在于需要预测k序列在树的哪个分支上
 * 还是使用一个简单递归解题即可
 */
public class PermutationSequence {
    public static void main(String[] args) {
        Utils.print(new PermutationSequence().getPermutation(3, 3));
        Utils.print(new PermutationSequence().getPermutation(4, 9));
        Utils.print(new PermutationSequence().getPermutation(3, 1));
        Utils.print(new PermutationSequence().getPermutation(1, 1));
    }

    Map<Integer, Integer> map;
    StringBuilder indexSb = new StringBuilder("1");
    StringBuilder result = new StringBuilder();

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";

        }
        // 全排列结果是n!，结果级是(n-1)!，所以数据可以先判断k的位置
        map = new HashMap<>(n);
        map.put(1, 1);
        for (int i = 2; i <= n; i++) {
            map.put(i, i * map.get(i - 1));
            indexSb.append(i);
        }
        String indexString = indexSb.toString();
        getPermutation(n, k, indexString);
        return result.toString();
    }

    public void getPermutation(int n, int k, String indexString) {
        if (n <= 0) {
            return;
        }
        // 判断k在第几个分支上
        int branchNodeCount = map.get(n) / n;
        int branchIndex = k / branchNodeCount;
        if (k % branchNodeCount > 0) {
            branchIndex += 1;
        }
        char c = indexString.charAt(branchIndex - 1);
        result.append(c);
        // 下次递归的k
        k = k - branchNodeCount * (branchIndex - 1);
        // 构建一个新的排除当前父节点(branchIndex)的序列
        indexString = indexString.replace(String.valueOf(c), "");
        getPermutation(n - 1, k, indexString);
    }
}
