package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 2698. 求一个整数的惩罚数
 */
public class Q2698 {
    public static void main(String[] args) {
        Utils.print(new Q2698().punishmentNumber(37));
    }

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(String.valueOf(i * i), 0, 0, i)) {
                res += i * i;
            }
        }
        return res;
    }

    private boolean dfs(String s, int pos, int tot, int target) {
        if (pos == s.length()) {
            return tot == target;
        }
        int sum = 0;
        for (int i = pos; i < s.length(); i++) {
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum + tot > target) {
                break;
            }
            if (dfs(s, i + 1, sum + tot, target)) {
                return true;
            }
        }
        return false;
    }
}
