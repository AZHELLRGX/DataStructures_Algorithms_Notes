package org.azhell.lanqiao;

import org.azhell.tool.Utils;

import java.util.Random;

/*
唯一成对的数：
1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现
一次。每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助存储空
间，能否设计一个算法实现？

解法一、显然已经有人提出了一个比较精彩的解法，将所有数加起来，减去1+2+...+1000的和。
这个算法已经足够完美了，相信出题者的标准答案也就是这个算法，唯一的问题是，如果数列过大，则可能会导致溢出。

解法二、异或就没有这个问题，并且性能更好。
将所有的数全部异或，得到的结果与1^2^3^...^1000的结果进行异或，得到的结果就是重复数。

解法三、利用辅助空间，将数值作为辅助数组的下标，辅助数组存储数值出现的次数
 */
public class UniquePairedNum {
    public static void main(String[] args) {
        int n = 11;
        int[] array = new int[n];
        for (int i = 0; i < n - 1; i++) {
            array[i] = i + 1;
        }
        Random random = new Random();
        // 生成随机数
        int randomNum = random.nextInt(n - 1) + 1;
        // 生成随机index
        int randomIndex = random.nextInt(n);
        int tempNum = array[randomIndex];
        array[randomIndex] = randomNum;
        array[n - 1] = tempNum;
        Utils.print(array);

        // 找出重复的数
        int x1 = 0;
        // 异或算法，（对于任何数x，都有x^x=0，x^0=x）
        for (int i = 1; i <= array.length - 1; i++) {
            x1 = x1 ^ i ^ array[i - 1];
        }
        // 别忘了还有数组的最后一个元素没有异或
        x1 = x1 ^ array[array.length - 1];
        Utils.print(x1);
        Utils.print("--------------------");
        // 利用辅助空间
        int[] helper = new int[n];
        for (int i : array) {
            helper[i]++;
        }
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] == 2) {
                Utils.print(i);
                break;
            }
        }
    }
}
