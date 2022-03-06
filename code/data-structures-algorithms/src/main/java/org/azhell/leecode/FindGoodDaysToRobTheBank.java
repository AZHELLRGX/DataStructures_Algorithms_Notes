package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2100. 适合打劫银行的日子
 * 动态规划
 * 两个dp数组
 */
public class FindGoodDaysToRobTheBank {
    public static void main(String[] args) {
        FindGoodDaysToRobTheBank f = new FindGoodDaysToRobTheBank();
        Utils.print(f.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
        Utils.print(f.goodDaysToRobBank(new int[]{1, 1, 1, 1, 1}, 0));
        Utils.print(f.goodDaysToRobBank(new int[]{1, 2, 3, 4, 5, 6}, 2));
        Utils.print(f.goodDaysToRobBank(new int[]{1}, 5));
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> result;
        int len = security.length;
        if (time == 0) {
            result = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                result.add(i);
            }
            return result;
        } else if (len <= time * 2) {
            return Collections.emptyList();
        }
        result = new ArrayList<>();
        int[] left = new int[len];
        left[0] = 0;
        int[] right = new int[len];
        right[len - 1] = 0;
        for (int i = 1; i < len - 1; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[len - i] >= security[len - i - 1]) {
                // 表示右侧有多少数字比自己大
                right[len - i - 1] = right[len - i] + 1;
            }
        }
        for (int i = time; i < len; i++) {
            if (left[i] >= time && right[i] >= time) {
                result.add(i);
            }
        }
        return result;
    }
}
