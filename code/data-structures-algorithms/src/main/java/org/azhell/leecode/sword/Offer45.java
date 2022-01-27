package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 根据 a + b和 b + a组成的数字排序
 */
public class Offer45 {
    public static void main(String[] args) {
        Offer45 o = new Offer45();
        Utils.print(o.minNumber(new int[]{10, 2}));
        Utils.print(o.minNumber(new int[]{3, 30, 34, 5, 9}));
        Utils.print(o.minNumber(new int[]{3}));
        Utils.print(o.minNumber(new int[]{999999998, 999999997, 999999999}));
        Utils.print(o.minNumber1(new int[]{999999998, 999999997, 999999999}));
    }

    // 下面这种方法效率要高不少
    public String minNumber1(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }

    public String minNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String a = nums[i] + "" + nums[j];
                String b = nums[j] + "" + nums[i];
                if (greater(a, b)) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private boolean greater(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return false;
            } else if (a.charAt(i) > b.charAt(i)) {
                return true;
            }
        }
        // 相等则不需要交换
        return false;
    }
}
