package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 393. UTF-8 编码验证
 */
public class UTF8Validation {
    public static void main(String[] args) {
        UTF8Validation u = new UTF8Validation();
        Utils.print(u.validUtf8(new int[]{197, 130, 1}));
        Utils.print(u.validUtf8(new int[]{235, 140, 4}));
    }


    public boolean validUtf8(int[] data) {
        int n = 0;
        for (int datum : data) {
            if (n > 0) {
                if (datum >> 6 != 2) return false;
                else n--;
            } else if (datum >> 7 == 0b0) {
                n = 0;
                // 除了看1的数量，还需要看1的后面跟的是否是0
            } else if (datum >> 5 == 0b110) {
                n = 1;
            } else if (datum >> 4 == 0b1110) {
                n = 2;
            } else if (datum >> 3 == 0b11110) {
                n = 3;
            } else {
                return false;
            }
        }
        return n == 0;
    }
}
