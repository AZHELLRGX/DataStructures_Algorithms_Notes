package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 461. 汉明距离
 * 右移求余数？
 */
public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance h = new HammingDistance();
        Utils.print(h.hammingDistance(1, 4));
        Utils.print(h.hammingDistance(3, 1));
    }

    public int hammingDistance(int x, int y) {
        int distance = 0;
        int i = 0;
        while (i < 32) {
            if ((x & 1) != (y & 1)) {
                distance += 1;
            }
            x >>= 1;
            y >>= 1;
            i++;
        }
        return distance;
    }

}
