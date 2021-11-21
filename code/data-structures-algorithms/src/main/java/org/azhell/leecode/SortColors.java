package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 75. 颜色分类
 * 计数排序
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        Utils.print(nums);
        nums = new int[]{1};
        sortColors.sortColors(nums);
        Utils.print(nums);
    }

    public void sortColors(int[] nums) {
        int[] countArray = new int[3];
        for (int num : nums) {
            countArray[num] = countArray[num] + 1;
        }
        int k = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                nums[k++] = i;
            }
        }
    }
}
