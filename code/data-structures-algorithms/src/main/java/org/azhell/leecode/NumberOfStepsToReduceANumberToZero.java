package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1342. 将数字变成 0 的操作次数
 */
public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        NumberOfStepsToReduceANumberToZero n = new NumberOfStepsToReduceANumberToZero();
        Utils.print(n.numberOfSteps(14));
        Utils.print(n.numberOfSteps(8));
        Utils.print(n.numberOfSteps(0));
        Utils.print(n.numberOfSteps(123));
    }

    public int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else num -= 1;
            steps += 1;
        }
        return steps;
    }
}
