package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 使用递归进行迭代
 */
public class LexicographicalNumbers {
    public static void main(String[] args) {
        LexicographicalNumbers l = new LexicographicalNumbers();
        Utils.print(l.lexicalOrder(13));
        Utils.print(l.lexicalOrder(2));
        Utils.print(l.lexicalOrder(123));
    }

    List<Integer> result;

    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (i > n) break;
            result.add(i);
            if (i * 10 <= n) {
                dfs(i * 10, n);
            }
        }
        return result;
    }

    private void dfs(int rootNum, int n) {
        for (int i = 0; i <= 9; i++) {
            final int j = rootNum + i;
            if (j > n) break;
            result.add(j);
            if (j * 10 <= n) {
                dfs(j * 10, n);
            }
        }
    }
}
