package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        SelfDividingNumbers s = new SelfDividingNumbers();
        Utils.print(s.selfDividingNumbers(1, 22));
        Utils.print(s.selfDividingNumbers(47, 85));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            final String s = Integer.toString(i);
            int j = 0;
            while (j < s.length()) {
                final char c = s.charAt(j);
                if (c == '0' || i % (c - '0') != 0) {
                    break;
                }
                j++;
            }
            if (j == s.length()) {
                res.add(i);
            }
        }
        return res;
    }
}
