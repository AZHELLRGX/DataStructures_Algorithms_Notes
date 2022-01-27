package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 注意本题里面的大小王可以变为任何牌
 */
public class Offer61 {
    public static void main(String[] args) {
        Offer61 o = new Offer61();
        Utils.print(o.isStraight(new int[]{1, 2, 3, 4, 5}));
        Utils.print(o.isStraight(new int[]{0, 0, 1, 2, 5}));
        Utils.print(o.isStraight(new int[]{11, 0, 9, 0, 0}));
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int cnt0 = 0;
        int diff = 0;
        // 判断重复
        Set<Integer> set = new HashSet<>(5);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt0 += 1;
            } else if (set.contains(nums[i])) {
                return false;
            } else {
                if (i > 0 && nums[i - 1] != 0) {
                    diff += nums[i] - nums[i - 1];
                }
                set.add(nums[i]);
            }
        }
        return diff - cnt0 <= 4;
    }
}
