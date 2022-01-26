package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 2013. 检测正方形
 * 尝试哈希表解题
 */
public class DetectSquares {
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        Utils.print(detectSquares.count(new int[]{11, 10}));
        Utils.print(detectSquares.count(new int[]{14, 8}));
        detectSquares.add(new int[]{11, 2});
        Utils.print(detectSquares.count(new int[]{11, 10}));
    }

    // 重复的点是允许的是，所以需要记录点的数量
    // x的hash表
    Map<Integer, Map<Integer, Integer>> rowMap;
    // y的hash表
    Map<Integer, Map<Integer, Integer>> colMap;

    public DetectSquares() {
        rowMap = new HashMap<>();
        colMap = new HashMap<>();
    }

    public void add(int[] point) {
        Map<Integer, Integer> map = rowMap.computeIfAbsent(point[0], key -> new HashMap<>());
        if (map.containsKey(point[1])) {
            map.put(point[1], map.get(point[1]) + 1);
        } else {
            map.put(point[1], 1);
        }
        map = colMap.computeIfAbsent(point[1], key -> new HashMap<>());
        if (map.containsKey(point[0])) {
            map.put(point[0], map.get(point[0]) + 1);
        } else {
            map.put(point[0], 1);
        }
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int cnt = 0;
        if (rowMap.containsKey(x) && colMap.containsKey(y)) {
            final Map<Integer, Integer> cols = rowMap.get(x);
            for (Map.Entry<Integer, Integer> entry : cols.entrySet()) {
                int y1 = entry.getKey();
                if (y != y1) {
                    // 边长
                    final int sideLen = Math.abs(y1 - y);
                    // y的坐标两个
                    int x2 = x - sideLen;
                    cnt += exists(x2, y, y1, entry.getValue());
                    x2 = x + sideLen;
                    cnt += exists(x2, y, y1, entry.getValue());
                }
            }
        }
        return cnt;
    }

    public int exists(int x2, int y, int y1, int c1) {
        int cnt = 0;
        // 判断第三、第四个点是否存在
        if (colMap.get(y).containsKey(x2) && colMap.containsKey(y1) && colMap.get(y1).containsKey(x2)) {
            cnt += c1 * colMap.get(y).get(x2) * colMap.get(y1).get(x2);
        }
        return cnt;
    }
}
