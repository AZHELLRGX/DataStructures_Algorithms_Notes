package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3数字之和
 * 感觉又是一个动态规划问题
 */
public class Q3Sum {

    public static void main(String[] args) {
        Q3Sum q3Sum = new Q3Sum();
        List<List<Integer>> lists = q3Sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer).append(",");
            }
            Utils.print(sb);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        // 两个指针
        int i = 0; // 步长为2
        while (i + 2 < nums.length) {
            int j = i + 2;
            while (j < nums.length) {
                if (nums[i] + nums[i + 1] + nums[j] == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[i + 1], nums[j]);
                    lists.add(list);
                }
                j++;
            }
            i += 1;
        }
        return lists;
    }
}
