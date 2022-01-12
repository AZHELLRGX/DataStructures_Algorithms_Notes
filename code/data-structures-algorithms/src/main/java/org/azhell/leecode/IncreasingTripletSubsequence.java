package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 334. 递增的三元子序列
 * 其他人的思路：不断更新最小值a和次小值b，而且在这个过程中不断找比a和b都大的第三个数c
 * 这个方法的可行之处就在于只要a或者b足够小，那么c的可选数字就越多
 * 题做多了逻辑自然就来了
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        Utils.print(i.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        Utils.print(i.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        Utils.print(i.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    public boolean increasingTriplet(int[] nums) {
        int b = Integer.MAX_VALUE;
        int a = b - 1;
        for (int num : nums) {
            if (num < a)
                a = num;
            else if (num < b && num > a)
                b = num;
            else if (num > b)
                return true;
        }
        return false;
    }
}
