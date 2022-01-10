package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 306. 累加数
 * 回溯法 + 字符串加法
 */
public class AdditiveNumber {
    public static void main(String[] args) {
        AdditiveNumber a = new AdditiveNumber();
        Utils.print(a.isAdditiveNumber("112358"));
        Utils.print(a.isAdditiveNumber("199100199"));
    }

    String num;
    int n;
    List<String> list;

    public boolean isAdditiveNumber(String num) {
        this.num = num;
        n = num.length();
        this.list = new ArrayList<>();
        return dfs(0);
    }

    boolean dfs(int index) {
        int m = list.size();
        if (index == n)
            return m >= 3;
        // 如果当前数是0，就只能是0，不能变成01这种字符串，因为没有意义
        int max = num.charAt(index) == '0' ? index + 1 : n;
        StringBuilder cur = new StringBuilder();
        for (int i = index; i < max; i++) {
            cur.append(num.charAt(i));
            // 加了一个小的剪枝
            if (m < 2 || (Math.max(list.get(m - 2).length(), list.get(m - 1).length()) + 1 >= cur.length() &&
                    check(list.get(m - 2), list.get(m - 1), cur.toString()))) {
                list.add(cur.toString());
                if (dfs(i + 1)) return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    // 用之前字符串相加的代码
    AddStrings addStrings = new AddStrings();

    boolean check(String a, String b, String c) {
        return c.equals(addStrings.addStrings(a, b));
    }
}

