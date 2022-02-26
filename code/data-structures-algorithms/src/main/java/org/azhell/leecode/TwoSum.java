package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 直接哈希表
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        Utils.print(t.twoSum(new int[]{2, 7, 11, 15}, 9));
        Utils.print(t.twoSum(new int[]{3, 2, 4}, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            final int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
