package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 85. 最大矩形
 * 每一层看作是柱状图，可以套用84题柱状图的最大面积。
 * 第一层柱状图的高度["1","0","1","0","0"]，最大面积为1；
 * 第二层柱状图的高度["2","0","2","1","1"]，最大面积为3；
 * 第三层柱状图的高度["3","1","3","2","2"]，最大面积为6；
 * 第四层柱状图的高度["4","0","0","3","0"]，最大面积为4；
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle m = new MaximalRectangle();
        Utils.print(m.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
        Utils.print(m.maximalRectangle(new char[][]{}));
        Utils.print(m.maximalRectangle(new char[][]{{'1'}}));
        Utils.print(m.maximalRectangle(new char[][]{{'0', '0'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        } else {
            LargestRectangleInHistogram l = new LargestRectangleInHistogram();
            int maxArea = 0;
            int[] heights = new int[matrix[0].length];
            for (char[] chars : matrix) {
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '1') {
                        heights[i] += 1;
                    } else {
                        heights[i] = 0;
                    }
                }
                maxArea = Math.max(maxArea, l.largestRectangleArea(heights));
            }
            return maxArea;
        }
    }
}
