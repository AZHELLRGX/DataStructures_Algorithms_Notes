package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * <p>
 * 使用递归代替循环，使用逻辑运算符的短路特性代替条件判断语句
 */
public class Offer64 {
    public static void main(String[] args) {
        Offer64 o = new Offer64();
        Utils.print(o.sumNums(0));
        Utils.print(o.sumNums(3));
        Utils.print(o.sumNums(9));
    }

    public int sumNums(int n) {
        // 虽然flag无用，但是java的语法规则要求逻辑表达式必须赋值给一个变量
        boolean flag = n > 0 && (n+=sumNums(n-1)) > 0;
        return n;
    }
}
