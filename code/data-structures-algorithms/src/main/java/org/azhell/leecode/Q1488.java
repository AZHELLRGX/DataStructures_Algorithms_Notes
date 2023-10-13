package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 1488. 避免洪水泛滥
 */
public class Q1488 {
    public static void main(String[] args) {
        int[] rains = new int[]{1, 2, 0, 0, 2, 1};
        Utils.print(new Q1488().avoidFlood(rains));
        rains = new int[]{1, 2, 0, 1, 2};
        Utils.print(new Q1488().avoidFlood(rains));
        rains = new int[]{69, 0, 0, 0, 69};
        Utils.print(new Q1488().avoidFlood(rains));
        rains = new int[]{0, 1, 1};
        Utils.print(new Q1488().avoidFlood(rains));
        rains = new int[]{1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3};
        Utils.print(new Q1488().avoidFlood(rains));
    }

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        TreeSet<Integer> noRainSet = new TreeSet<>();
        Map<Integer, Integer> rainedLakeDayMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int lakeNum = rains[i];
            if (lakeNum > 0) {
                if (rainedLakeDayMap.containsKey(lakeNum)) {
                    // ceilingKey(K key) 方法用于返回最小键大于或等于返回到给定的键，如果不存在，则返回null
                    Integer noRainDay = noRainSet.ceiling(rainedLakeDayMap.get(lakeNum));
                    if (noRainDay == null) {
                        return new int[]{};
                    }
                    noRainSet.remove(noRainDay);
                    result[noRainDay] = lakeNum;
                }
                // 这个地方一定不能写在else中，因为虽然湖泊腾空了，但是这次又下满了
                rainedLakeDayMap.put(lakeNum, i);

                result[i] = -1;
            } else {
                noRainSet.add(i);
            }
        }
        return result;
    }
}
