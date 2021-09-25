package org.azhell.leecode;


import org.azhell.tool.Utils;

/**
 * 盛水最多的容器
 * 解题思路：双指针；动态规划
 * todo 性能较差，后续回头优化
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Utils.print(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Utils.print(maxArea(new int[]{1, 1}));
        Utils.print(maxArea(new int[]{4, 3, 2, 1, 4}));
        Utils.print(maxArea(new int[]{1, 2, 1}));
    }


    private static int maxArea(int[] height) {
        return getMaxArea(0, height.length - 1, height);
    }

    // 设置头尾两个指针
    private static int getMaxArea(int i, int j, int[] height) {
        if (i >= j) return 0;
        int area;
        // 移动左指针
        if (height[i] < height[j]) {
            area = (j - i) * height[i];
            i += 1;
        } else {
            area = (j - i) * height[j];
            j -= 1;
        }
        return Math.max(getMaxArea(i, j, height), area);
    }

}
