package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 55. 跳跃游戏
 * 贪心算法
 */
public class JumpGame {
    public static void main(String[] args) {
        Utils.print(new JumpGame().canJump(new int[]{2, 3, 1, 2, 0, 1}));
        Utils.print(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int jumpEnd = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 是否可以在能跳范围内跳的更远
            maxPos = Math.max(nums[i] + i, maxPos);
            // 当前跳范围已经结束，将最远可以跳的距离赋值给end
            if (i == jumpEnd) {
                jumpEnd = maxPos;
            }
        }
        // 其实跳不到最后唯一的问题就是有0，而且某一跳无论如何都跳不过这个0
        return jumpEnd >= nums.length - 1;
    }
}
