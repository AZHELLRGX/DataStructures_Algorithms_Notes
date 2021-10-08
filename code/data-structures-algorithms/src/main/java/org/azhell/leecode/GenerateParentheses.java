package org.azhell.leecode;

import org.azhell.tool.Utils;


import java.util.ArrayList;
import java.util.List;


/**
 * 括号生成
 * 深度优先搜索DFS
 * todo DFS和BFS等以后做的题多了慢慢理解吧
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        Utils.print(new GenerateParentheses().generateParenthesis(3));
        Utils.print(new GenerateParentheses().generateParenthesis(4));
        Utils.print(new GenerateParentheses().generateParenthesis(5));
        Utils.print(new GenerateParentheses().generateParenthesis(1));
    }

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        func("", 0, 0, n);
        return res;
    }

    private void func(String str, int l, int r, int n) {
        if (l > n || r > n || r > l) return;
        if (l == n && r == n) {
            res.add(str);
            return;
        }
        func(str + '(', l + 1, r, n);
        func(str + ')', l, r + 1, n);
    }
}
