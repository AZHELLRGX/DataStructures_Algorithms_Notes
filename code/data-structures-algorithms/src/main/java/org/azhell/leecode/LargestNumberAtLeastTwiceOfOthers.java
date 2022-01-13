package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 747. 至少是其他数字两倍的最大数
 * 找出最大数和次大数即可
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers l = new LargestNumberAtLeastTwiceOfOthers();
        Utils.print(l.dominantIndex(new int[]{3, 6, 1, 0}));
        Utils.print(l.dominantIndex(new int[]{1, 2, 3, 4}));
        Utils.print(l.dominantIndex(new int[]{1}));
        Utils.print(l.dominantIndex(new int[]{0, 0, 0, 1}));
        Utils.print(l.dominantIndex(new int[]{1, 0}));
        Utils.print(l.dominantIndex(new int[]{0, 1}));
        Utils.print(l.dominantIndex(new int[]{0, 0, 3, 2}));
    }

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxFirIndex = 0;
        int maxSecIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[maxFirIndex] < nums[i]) {
                maxSecIndex = maxFirIndex;
                maxFirIndex = i;
            } else if (nums[maxFirIndex] > nums[i] && nums[maxSecIndex] < nums[i]) {
                maxSecIndex = i;
            }
        }
        if (nums[maxFirIndex] / 2 >= nums[maxSecIndex]) {
            return maxFirIndex;
        } else {
            return -1;
        }
    }
}
