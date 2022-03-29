package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1004. 最大连续1的个数 III
 * 这道题也是滑动窗口（双指针）的思想
 * 需要注意的是题目只要求1的最大数量
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        MaxConsecutiveOnes3 m = new MaxConsecutiveOnes3();
        Utils.print(m.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        Utils.print(m.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        Utils.print(m.longestOnes(new int[]{0, 0, 0, 0}, 0));
    }

    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int zeroSum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (0 == nums[right]) {
                zeroSum += 1;
            }
            right += 1;
            // 移动窗口左指针，直到0的数量不超过k
            while (zeroSum > k) {
                if (0 == nums[left]) {
                    zeroSum -= 1;
                }
                left += 1;
            }
            max = Math.max(right - left, max);
        }
        return max;
    }
}
