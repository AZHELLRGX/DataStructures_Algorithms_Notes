package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 还是依旧是回溯法
 */
public class Permutations {

    public static void main(String[] args) {
        Utils.print(new Permutations().permute(new int[]{1, 2, 3}));
        Utils.print(new Permutations().permute(new int[]{0, 1}));
        Utils.print(new Permutations().permute(new int[]{1}));
        Utils.print(new Permutations().permute(new int[]{1,1,2}));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permuteHandle(nums, new ArrayList<>(), used);
        return result;
    }

    public void permuteHandle(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    list.add(nums[i]);
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
