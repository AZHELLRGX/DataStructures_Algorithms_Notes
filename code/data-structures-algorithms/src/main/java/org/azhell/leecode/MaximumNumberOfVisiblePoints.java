package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1610. 可见点的最大数目
 * 1、首先计算出各个点相对于你的位置的极角大小，角度大小的计算在这里我们可以使用库函数atan2
 * 2、将极角从小到大进行排序后，利用双指针p1,p2维护我们的窗口，使得degree[p2] - degree[p1] < 视野范围即可
 */
public class MaximumNumberOfVisiblePoints {
    public static void main(String[] args) {
        MaximumNumberOfVisiblePoints m = new MaximumNumberOfVisiblePoints();
        List<List<Integer>> points = Utils.initNestedList(new Integer[][]{{2, 1}, {2, 2}, {3, 3}});
        List<Integer> location = Utils.initList(new Integer[]{1, 1});
        Utils.print(m.visiblePoints(points, 90, location));
    }

    double eps = 1e-9;

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0);
        int y = location.get(1);
        List<Double> list = new ArrayList<>();
        int cnt = 0;
        double pi = Math.PI;
        for (List<Integer> p : points) {
            int a = p.get(0);
            int b = p.get(1);
            // 题目规定了与 location 重合的点在任意角度都能看到，因此我们需要对这些点进行特殊处理
            // 重合的点只需要记录一次即可
            if (a == x && b == y && ++cnt >= 0) continue;
            list.add(Math.atan2(b - y, a - x) + pi);
        }
        // 所有点的极角排序
        Collections.sort(list);
        // 将angle也用double表示
        double t = angle * pi / 180;
        int n = list.size();
        int max = 0;
        for (int i = 0; i < n; i++) list.add(list.get(i) + 2 * pi);
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t + eps) i++;
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }
}
