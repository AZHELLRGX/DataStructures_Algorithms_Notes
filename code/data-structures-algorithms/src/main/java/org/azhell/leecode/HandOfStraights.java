package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.TreeMap;

/**
 * 846. 一手顺子
 * 贪心算法
 * 使用TreeMap，效率差了点，不过也够用了
 */
public class HandOfStraights {
    public static void main(String[] args) {
        HandOfStraights h = new HandOfStraights();
        Utils.print(h.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        Utils.print(h.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        initMap(hand, map);
        // 依次往后找递增序列
        while (!map.isEmpty()) {
            int temp = groupSize;
            int currentEle = -1;
            while (temp > 0) {
                if (map.isEmpty()) {
                    return false;
                }
                if (currentEle == -1) {
                    currentEle = map.firstKey();// 取第一个数作为新顺子的开头
                    handleMap(currentEle, map);
                } else {
                    // 找顺子的下一个数
                    currentEle = currentEle + 1;
                    if (!map.containsKey(currentEle)) {
                        return false;
                    } else {
                        handleMap(currentEle, map);
                    }
                }
                temp--;
            }
        }
        return true;
    }

    private void initMap(int[] hand, TreeMap<Integer, Integer> map) {
        for (int i : hand) {
            map.put(i, map.computeIfAbsent(i, key -> 0) + 1);
        }
    }

    private void handleMap(int currentEle, TreeMap<Integer, Integer> map) {
        if (map.get(currentEle) - 1 == 0) {
            map.remove(currentEle);
        } else {
            map.put(currentEle, map.get(currentEle) - 1);
        }
    }
}
