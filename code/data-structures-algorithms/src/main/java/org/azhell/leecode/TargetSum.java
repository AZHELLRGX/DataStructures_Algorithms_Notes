package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. 目标和
 * DFS + hash剪枝
 */
public class TargetSum {
    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        Utils.print(t.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        Utils.print(t.findTargetSumWays(new int[]{1}, 1));
    }

    // 记录走到nums是否可以直接推导继续走完的可能性
    Map<Integer, Map<Integer, Integer>> map;
    int[] nums;


    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.map = new HashMap<>();
        return findTargetSumWaysHelper(0, target);
    }

    private int findTargetSumWaysHelper(int curIndex, int target) {
        if (curIndex == nums.length) {
            return target == 0 ? 1 : 0;
        } else {
            return getAns(curIndex, target - nums[curIndex]) + getAns(curIndex, target + nums[curIndex]);
        }
    }

    private int getAns(int curIndex, int target) {
        if (map.containsKey(curIndex) && map.get(curIndex).containsKey(target)) {
            return map.get(curIndex).get(target);
        } else {
            int ans = findTargetSumWaysHelper(curIndex + 1, target);
            map.computeIfAbsent(curIndex, key -> new HashMap<>()).put(target, ans);
            return ans;
        }
    }
}
