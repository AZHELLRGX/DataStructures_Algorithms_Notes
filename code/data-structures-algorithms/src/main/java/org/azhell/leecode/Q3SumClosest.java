package org.azhell.leecode;


import org.azhell.tool.Utils;

/**
 * 最接近的三数之和
 */
public class Q3SumClosest {
    public static void main(String[] args) {
        Utils.print(new Q3SumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    private int threeSumClosest(int[] nums, int target) {
        // 其实是上一题的简化版本
        // 需要先排序，非重点
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length; k++) {
            int i = k + 1; // 从当前数据的下一位开始找起
            int j = nums.length - 1;
            while (i < j) {
                int temp = nums[i] + nums[j] + nums[k];
                int divide = temp - target;
                int tempMin = Math.abs(divide);
                if (tempMin < min) {
                    result = temp;
                    min = tempMin;
                }
                // 移动指针
                if (divide > 0) {
                    i++;
                } else if (divide < 0) {
                    j--;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}

