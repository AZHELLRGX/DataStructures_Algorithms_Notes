package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 954. 二倍数对数组
 * 哈希 + 排序
 */
public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        ArrayOfDoubledPairs a = new ArrayOfDoubledPairs();
        Utils.print(a.canReorderDoubled(new int[]{3, 1, 3, 6}));
        Utils.print(a.canReorderDoubled(new int[]{2, 1, 2, 6}));
        Utils.print(a.canReorderDoubled(new int[]{4, -2, 2, -4}));
        Utils.print(a.canReorderDoubled(new int[]{4, -4, 4, -2, -4, -8}));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.comparing(Math::abs));
        for (int a : list) {
            final Integer cnt = map.get(a);
            if (map.getOrDefault(a * 2, 0) < cnt) {
                return false;
            }
            map.remove(a);
            map.merge(a * 2, -cnt, Integer::sum);
        }
        return true;
    }
}
