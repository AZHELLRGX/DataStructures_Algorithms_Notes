package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * 哈希表
 */
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        MinimumIndexSumOfTwoLists m = new MinimumIndexSumOfTwoLists();
        Utils.print(m.findRestaurant(list1, list2));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = 2000;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = map.get(list2[i]) + i;
                if (indexSum == min) {
                    res.add(list2[i]);
                } else if (indexSum < min) {
                    res = new ArrayList<>(Collections.singletonList(list2[i]));
                    min = indexSum;
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
