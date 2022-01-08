package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 89. 格雷编码
 * 背答案的题目
 * n位的格雷编码就是在n-1的基础上添加 0 和 1 ；1添加完成后需要翻转
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode g = new GrayCode();
        Utils.print(g.grayCode(3));
        Utils.print(g.grayCode1(3));
    }

    public List<Integer> grayCode1(int n) {
        /*
         关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
         如 n = 3:
         G(0) = 000,
         G(1) = 1 ^ 0 = 001 ^ 000 = 001
         G(2) = 2 ^ 1 = 010 ^ 001 = 011
         G(3) = 3 ^ 1 = 011 ^ 001 = 010
         G(4) = 4 ^ 2 = 100 ^ 010 = 110
         G(5) = 5 ^ 2 = 101 ^ 010 = 111
         G(6) = 6 ^ 3 = 110 ^ 011 = 101
         G(7) = 7 ^ 3 = 111 ^ 011 = 100
         */
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i)
            ret.add(i ^ i >> 1);
        return ret;
    }

    public List<Integer> grayCode(int n) {
        final int size = (int) Math.pow(2, n);
        List<String> data = new ArrayList<>(size);
        List<Integer> result = new ArrayList<>(size);
        data.add("0");
        data.add("1");
        int i = 1;
        while (i < n) {
            final int pow = (int) Math.pow(2, i);
            String[] arr0 = new String[pow];
            String[] arr1 = new String[pow];
            for (int j = 0; j < data.size(); j++) {
                arr0[j] = "0" + data.get(j);
                arr1[j] = "1" + data.get(j);
            }
            data.clear();
            data.addAll(Arrays.asList(arr0));
            for (int j = arr1.length - 1; j >= 0; j--) {
                data.add(arr1[j]);
            }
            i++;
        }
        for (String datum : data) {
            result.add(Integer.valueOf(datum, 2));
        }
        return result;
    }
}
