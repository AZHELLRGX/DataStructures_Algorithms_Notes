package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1220. 统计元音字母序列的数目
 * 动态规划，每种元音结尾的情况均由前一个字母推导而来
 * 注意数据需要取模
 */
public class CountVowelsPermutation {
    public static void main(String[] args) {
        CountVowelsPermutation c = new CountVowelsPermutation();
        Utils.print(c.countVowelPermutation(1));
        Utils.print(c.countVowelPermutation(2));
        Utils.print(c.countVowelPermutation(144));
    }

    public int countVowelPermutation(int n) {
        final int M = 1000000007;
        long[][] dp = new long[n][5];
        // 初始的时候，每种元音的概率相等 a（'a', 'e', 'i', 'o', 'u'）
        dp[0] = new long[]{1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            final long[] previous = dp[i - 1];
            // 后面可以跟着a的元音是e,i,u
            long aCnt = previous[1] + previous[2] + previous[4];
            // 后面可以跟着e的元音是a,i
            long eCnt = previous[0] + previous[2];
            // 后面可以跟着i的元音是e,o
            long iCnt = previous[1] + previous[3];
            // 后面可以跟着o的元音是i
            long oCnt = previous[2];
            // 后面可以跟着u的元音是i,o
            long uCnt = previous[2] + previous[3];
            dp[i] = new long[]{aCnt % M, eCnt % M, iCnt % M, oCnt % M, uCnt % M};
        }
        final long[] result = dp[dp.length - 1];
        long count = 0;
        for (long i : result) {
            count += i;
        }
        return (int) (count % M);
    }
}
