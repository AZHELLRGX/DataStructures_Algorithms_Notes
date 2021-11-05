package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 跳跃游戏 II
 * 使用贪心算法解题
 * 题目里面有一个很重要的信息，总是可以到达最后一个位置
 */
public class JumpGame2 {
    public static void main(String[] args) {
        Utils.print(new JumpGame2().jump(new int[]{2, 3, 1, 1, 4}));
        Utils.print(new JumpGame2().jump(new int[]{2, 3, 0, 1, 4}));
        Utils.print(new JumpGame2().jump(new int[]{0}));
        Utils.print(new JumpGame2().jump(new int[]{1, 2}));
    }

    public int jump(int[] nums) {
        int jumpCount = 0;
        int end = 0;
        int maxPos = 0;
        // 遍历到结果的前一步即可
        for (int i = 0; i < nums.length - 1; i++) {
            // 下一步可以跳跃的最大距离
            maxPos = Math.max(nums[i] + i, maxPos);
            // 当前范围已经遍历结束
            if (i == end) {
                // 跳一次
                end = maxPos;
                jumpCount++;
            }
        }
        return jumpCount;
    }
}
