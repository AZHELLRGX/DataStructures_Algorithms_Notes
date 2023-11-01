package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 杨辉三角
 */
public class Q118 {
    public static void main(String[] args) {
        Utils.print(new Q118().generate(5));
        Utils.print(new Q118().getRow(5));
    }

    /**
     * 118. 杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }

    /**
     * 119. 杨辉三角 II
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preList = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            int left = 1;
            for (int j = 1; j < i; j++) {
                int curJNum = left + preList.get(j);
                left = preList.get(j);
                preList.set(j, curJNum);
            }
            preList.add(1);
        }
        return preList;
    }
}
