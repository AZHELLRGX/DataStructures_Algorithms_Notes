package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 2024. 考试的最大困扰度
 * 这道题一时不容易想出来
 * 题解的意思是使用滑动窗口，窗口占比较小的字符数量为sum
 * 按照具体的思想实现
 */
public class MaximizeTheConfusionOfAnExam {
    public static void main(String[] args) {
        MaximizeTheConfusionOfAnExam m = new MaximizeTheConfusionOfAnExam();
        Utils.print(m.maxConsecutiveAnswers("TTFF", 2));
        Utils.print(m.maxConsecutiveAnswers("TFFT", 1));
        Utils.print(m.maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = 0;
        int tSum = 0;
        int fSum = 0;
        int left = 0;
        int right = 0;
        while (right < answerKey.length()) {
            if ('T' == answerKey.charAt(right)) {
                tSum += 1;
            } else {
                fSum += 1;
            }
            right += 1;
            int sum = Math.min(tSum, fSum);
            // 如果不同字符已经不能被全部替换，则窗口右移
            if (sum > k) {
                if ('T' == answerKey.charAt(left)) {
                    tSum -= 1;
                } else {
                    fSum -= 1;
                }
                left += 1;
            }
            max = Math.max(right - left, max);
        }
        return max;
    }
}
