package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 接雨水
 * 双指针解法
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Utils.print(new TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5}));
        Utils.print(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        Utils.print(new TrappingRainWater().trap(new int[]{4, 2, 3}));
        Utils.print(new TrappingRainWater().trap(new int[]{5, 4, 1, 2}));
    }

    public int trap(int[] height) {
        int result = 0;
        int i = 0;
        int j = 1;
        // 只要找到比当前高的就可以蓄水
        while (j < height.length) {
            if (height[i] <= height[j]) {
                result += getArea(i, j, height[i], height);
                i = j;
            }
            j++;
        }
        // 找完都没找到，从后开始往前找比它自身大的
        // 还是选择让j动，不过是从后往前动
        int k = i;
        if (i < height.length - 1) {
            i = height.length - 1;
            j = height.length - 2;
            while (j >= k) {
                if (height[i] <= height[j]) {
                    result += getArea(j, i, height[i], height);
                    i = j;
                }
                j--;
            }
        }
        return result;
    }

    // 求蓄水面积
    public int getArea(int min, int max, int h, int[] height) {
        int area = h * (max - min - 1);
        for (int k = min + 1; k < max; k++) {
            area -= height[k];
        }
        return area;
    }
}
