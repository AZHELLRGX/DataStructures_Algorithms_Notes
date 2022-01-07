package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1614. 括号的最大嵌套深度
 * 直接判断括号的深度好像就可以
 */
public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses m = new MaximumNestingDepthOfTheParentheses();
        Utils.print(m.maxDepth("(1+(2*3)+((8)/4))+1"));
        Utils.print(m.maxDepth("(1)+((2))+(((3)))"));
        Utils.print(m.maxDepth("1+(2*3)/(2-1)"));
        Utils.print(m.maxDepth("1"));
    }


    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (s.charAt(i) == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}
