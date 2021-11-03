package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 * 还是依旧是回溯法
 */
public class Permutations2 {

    public static void main(String[] args) {
        Utils.print(new Permutations2().permuteUnique(new int[]{1, 1, 2}));
        Utils.print(new Permutations2().permuteUnique(new int[]{3,3,0,3}));
        Utils.print(new Permutations2().permuteUnique(new int[]{1, 2, 3}));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 排序是为了剪枝优化
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuteHandle(nums, new ArrayList<>(), used);
        return result;
    }

    public void permuteHandle(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            // 记录上一个值，重复的不需要再走一遍
            int previousNum = -11;
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && previousNum != nums[i]) {
                    list.add(nums[i]);
                    previousNum = nums[i];
                    used[i] = true;
                    // 递归
                    permuteHandle(nums, list, used);
                    // 回退
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
