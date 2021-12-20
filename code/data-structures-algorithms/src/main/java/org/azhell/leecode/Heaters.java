package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 475. 供暖器
 * 先将供暖期数据排序
 * 然后对每个房屋数据，找到最近的供暖器
 * 所有房屋都找完了，最大的那个就是最短半径
 */
public class Heaters {
    public static void main(String[] args) {
        Heaters heaters = new Heaters();
        Utils.print(heaters.findRadius(new int[]{1, 2, 3, 5, 15}, new int[]{2, 30}));
        Utils.print(heaters.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        Utils.print(heaters.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        Utils.print(heaters.findRadius(new int[]{1, 5}, new int[]{2}));
        Utils.print(heaters.findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));

    }

    public int findRadius(int[] houses, int[] heaters) {
        H[] hs = new H[houses.length + heaters.length];
        int i = 0;
        for (int house : houses) {
            hs[i++] = new H(house, false);
        }
        for (int heater : heaters) {
            hs[i++] = new H(heater, true);
        }
        Arrays.sort(hs);
        int minRadius = Integer.MIN_VALUE;
        // 往前往后查找
        for (int j = 0; j < hs.length; j++) {
            if (!hs[j].heaterIs) {
                int x = 1;
                boolean left = false;
                boolean right = false;
                int radius = Integer.MAX_VALUE;
                while (x + j < hs.length || j - x >= 0) {
                    if (!right && x + j < hs.length && hs[x + j].heaterIs) {
                        radius = Math.min(radius, hs[x + j].pos - hs[j].pos);
                        right = true;
                    }
                    if (!left && j - x >= 0 && hs[j - x].heaterIs) {
                        radius = Math.min(radius, hs[j].pos - hs[j - x].pos);
                        left = true;
                    }
                    if (right && left) {
                        break;
                    }
                    x++;
                }
                minRadius = Math.max(radius, minRadius);
            }
        }
        return minRadius;
    }

    static class H implements Comparable<H> {
        int pos;
        boolean heaterIs;

        H(int pos, boolean heaterIs) {
            this.pos = pos;
            this.heaterIs = heaterIs;
        }

        @Override
        public int compareTo(H h) {
            return this.pos - h.pos;
        }
    }
}
