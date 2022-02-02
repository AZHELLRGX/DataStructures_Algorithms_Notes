package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 547. 省份数量
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        NumberOfProvinces n = new NumberOfProvinces();
        Utils.print(n.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
        Utils.print(n.findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
        Utils.print(n.findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        }));
    }

    boolean[] inProvince;
    int[][] isConnected;
    int n;

    public int findCircleNum(int[][] isConnected) {
        this.n = isConnected.length;
        this.inProvince = new boolean[n];
        this.isConnected = isConnected;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!inProvince[i]) {
                ans += 1;
                // 开始将有关系的城市全部置为true
                isSameProvince(i);
            }
        }
        return ans;
    }

    private void isSameProvince(int i) {
        for (int j = 0; j < n; j++) {
            if (!inProvince[j] && isConnected[i][j] == 1) {
                inProvince[j] = true;
                isSameProvince(j);
            }
        }
    }
}
