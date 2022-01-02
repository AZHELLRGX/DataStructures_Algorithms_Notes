package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 390. 消除游戏
 * 只要判断第一个数字就可以了
 * 1、左侧删除的时候一定会改编第一个数字
 * 2、右侧删除的时候只有当剩余数据是奇数的时候，才会删除第一个数字
 * 3、数据是按照2的n次方进行跳跃删除的
 * 删除到只剩一个数字的时候，就是结果了
 */
public class EliminationGame {
    public static void main(String[] args) {
        EliminationGame e = new EliminationGame();
        Utils.print(e.lastRemaining(9));
        Utils.print(e.lastRemaining(1));
    }

    public int lastRemaining(int n) {
        // 当前是第几步删除
        int step = 1;
        // 还存在多少个数字
        int remain = n;
        // 是否是左侧删除
        boolean left = true;
        // 左侧第一个数字
        int firstNum = 1;
        while (remain > 1) {
            if (left) {
                firstNum = firstNum + step;
                left = false;
            } else {
                if (remain % 2 == 1) {
                    firstNum = firstNum + step;
                }
                left = true;
            }
            step *= 2;
            remain = remain / 2;
        }
        return firstNum;
    }
}
