package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 试试回溯法 回溯法耗时较久，毕竟是穷举嘛
 * 还有一种官方推荐的解法是双指针，但是代码写起来很乱很长哈哈
 * 双指针的解法原理就是本来暴力可以用4层循环，但是最后两层循环可以用夹逼原理代替
 */
public class Q4Sum {

    public static void main(String[] args) {
        Utils.print(new Q4Sum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        Utils.print(new Q4Sum().fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        Utils.print(new Q4Sum().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
        Utils.print(new Q4Sum().fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
        Utils.print(new Q4Sum().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
        Utils.print(new Q4Sum().fourSum(new int[]{4, -9, -2, -2, -7, 9, 9, 5, 10, -10, 4, 5, 2, -4, -2, 4, -9, 5}, -13));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 遇到重复值，剪枝优化
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    // 第二层剪枝
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int tempTarget = target - nums[i] - nums[j];

                        // 最内层使用双指针解
                        int left_index = j + 1;
                        int right_index = nums.length - 1;
                        while (left_index < right_index) {
                            // 与刚才使用的数据比较，遇到重复值继续跳一格
                            if (left_index != j + 1 && nums[left_index] == nums[left_index - 1]) {
                                left_index++;
                                continue;
                            }
                            if (right_index != nums.length - 1 && nums[right_index] == nums[right_index + 1]) {
                                right_index--;
                                continue;
                            }
                            // 最内层还是需要去重
                            int temp = nums[left_index] + nums[right_index];
                            if (temp == tempTarget) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[left_index], nums[right_index]));
                                left_index++;
                                right_index--;
                            } else if (temp < tempTarget) {
                                left_index++;
                            } else {
                                right_index--;
                            }
                        }

                    }
                }
            }
        }
        return result;
    }

    /*
    回溯法
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        fourSumHandle(nums, target, 0, new ArrayList<>());
        return result;
    }

    /*
    回溯法递归函数
    */
    public void fourSumHandle(int[] nums, int target, int j, List<Integer> list) {
        if (list.size() == 4) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
        } else {
            // 记录上一个值，重复的分支没必要重复走，剪枝优化
            int previousNum = Integer.MIN_VALUE;
            for (int i = j; i < nums.length; i++) {
                if (nums[i] != previousNum) {
                    previousNum = nums[i];
                    list.add(nums[i]);
                    fourSumHandle(nums, target - nums[i], i + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
