package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 169. 多数元素
 * 本题是一道简单题
 * 1、可以使用排序后中位数的方法
 * 2、哈希表算法
 * 3、摩尔投票算法
 */
public class Offer39 {
    public static void main(String[] args) {
        Offer39 o = new Offer39();
        Utils.print(o.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int card = 0;
        for (int num : nums) {
            if (count == 0) card = num;
            // 遇到相同的就加1，不同的就减1
            count += (card == num) ? 1 : -1;
        }
        return card;
    }
}
