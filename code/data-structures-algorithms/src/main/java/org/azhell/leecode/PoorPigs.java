package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 458. 可怜的小猪
 * 思路： 一个猪代表一个维度
 * 例如：两头猪代表两个维度,一头猪代表行row,一头猪代表列column
 * 通过minutesToTest/minutesToDie获取可以测试的轮数.
 * 如：我们有25个桶,5行5列.
 * 第1次,测试第1行,第1列
 * 第2次,测试第2行,第2列 ......
 * 行猪死在第3次,列猪死在第2次,说明第3行第2列的桶是***
 * 实际上,并不用测试满5次,第4次时就可以确定答案了
 * 如果测试完第4次后,行猪和列猪都没有死,说明第5行第5列的桶是***,而无需额外的测试
 * 所以每一个维度的最大值为minutesToTest/minutesToDie+1
 * 那么我们只需要确定需要有多少个维度(猪)能够满足条件即可
 */
public class PoorPigs {

    public static void main(String[] args) {
        Utils.print(new PoorPigs().poorPigs(1000, 15, 60));
        Utils.print(new PoorPigs().poorPigs(4, 15, 15));
        Utils.print(new PoorPigs().poorPigs(4, 15, 30));
        Utils.print(new PoorPigs().poorPigs(1, 1, 1));
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1){
            return 0; // 只有一桶，一定有毒
        }
        // 单只小猪最多可以检测多少桶水
        int x = minutesToTest / minutesToDie + 1;
        int i = 1;
        // 多少维才满足条件
        while (Math.pow(x, i) < buckets) {
            i++;
        }
        return i;
    }
}
