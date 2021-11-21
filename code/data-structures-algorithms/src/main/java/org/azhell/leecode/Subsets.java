package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 78. 子集
 * 依旧是回溯法
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        Utils.print(subsets.subsets(nums));
        nums = new int[]{0};
        subsets.result = new ArrayList<>();
        Utils.print(subsets.subsets(nums));
        nums = new int[]{4, 3, 1, 2};
        subsets.result = new ArrayList<>();
        Utils.print(subsets.subsets(nums));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 子集一共是多层
        result.add(Collections.emptyList());
        for (int i = 1; i <= nums.length; i++) {
            subsets(nums, 0, i, new ArrayList<>(i));
        }
        return result;
    }

    private void subsets(int[] nums, int j, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = j; i < nums.length; i++) {
                list.add(nums[i]);
                subsets(nums, i + 1, k, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
