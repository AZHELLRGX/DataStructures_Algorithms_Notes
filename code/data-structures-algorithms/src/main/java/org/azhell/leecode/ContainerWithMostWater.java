package org.azhell.leecode;


import org.azhell.tool.Utils;

/**
 * 11.盛水最多的容器
 * 解题思路：双指针；动态规划
 * todo 性能较差，后续回头优化
 * 20220202 已经优化
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        Utils.print(c.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Utils.print(c.maxArea(new int[]{1, 1}));
        Utils.print(c.maxArea(new int[]{4, 3, 2, 1, 4}));
        Utils.print(c.maxArea(new int[]{1, 2, 1}));
    }

    public int maxArea(int[] height) {
        // 设置头尾两个指针
        int i = 0;
        int j = height.length - 1;
        if (i >= j) return 0;
        int area = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                area = Math.max(area, (j - i) * height[i]);
                // 移动左指针
                i += 1;
            } else {
                area = Math.max(area, (j - i) * height[j]);
                // 移动右指针
                j -= 1;
            }
        }
        return area;
    }
}
