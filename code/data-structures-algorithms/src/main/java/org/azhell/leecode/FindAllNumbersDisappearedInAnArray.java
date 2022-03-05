package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 题目的难点在于不使用额外空间，并且时间复杂度为O(n)
 * 所以必须让数组里面的数字发挥它应有的作用
 * 解法：让数字对对应的数组下标占位标识，没有被占位的下标就是缺失的数字
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray f = new FindAllNumbersDisappearedInAnArray();
        Utils.print(f.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            final int abs = Math.abs(num) - 1;
            if (nums[abs] > 0) {
                nums[abs] = -nums[abs];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
