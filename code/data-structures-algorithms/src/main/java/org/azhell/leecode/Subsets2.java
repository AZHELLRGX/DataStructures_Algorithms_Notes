package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 90. 子集 II
 * 与78题的差别是，这里的数据是可能重复的
 * 其实就是需要一定的剪枝优化
 */
public class Subsets2 {
    public static void main(String[] args) {
        Subsets2 s = new Subsets2();
        Utils.print(s.subsetsWithDup(new int[]{1, 2, 2}));
        Utils.print(s.subsetsWithDup(new int[]{0}));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        // 子集一共是多层
        result.add(Collections.emptyList());
        for (int i = 1; i <= nums.length; i++) {
            subsetsWithDup(nums, 0, i, new ArrayList<>(i));
        }
        return result;
    }

    private void subsetsWithDup(int[] nums, int j, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            int lastNum = -11; // 数据范围是[-10,10]
            for (int i = j; i < nums.length; i++) {
                if (nums[i] != lastNum) {
                    list.add(nums[i]);
                    subsetsWithDup(nums, i + 1, k, list);
                    lastNum = list.remove(list.size() - 1);
                }
            }
        }
    }

}
