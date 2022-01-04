package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 877. 石子游戏
 * 博弈问题
 * 动态规划，使用二维dp数组，dp[i][j]表示从i到j的石子堆中，当前玩家与对手差距的最大值；当前玩家可能是Alice，也可能是Bob
 * 确定几个状态：
 * 1、只有当i<=j,剩下的石子堆才有意义，所以当i>j,dp[i][j] = 0
 * 2、当i=j的时候，其实就只有一个石子堆，所以此时dp[i][i] = piles[i]
 * 3、其他情况，每次当前玩家有两个选择，左侧石子堆或者右侧石子堆
 * dp[i][j] = piles[i] - dp[i+1][j] 或 dp[i][j] = piles[j] - dp[i][j-1]
 * 所以对于当前玩家，dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
 * <p>
 * todo 博弈类型问题需要好好思考思路，dp不难，主要是解题思路、套路
 */
public class StoneGame {
    public static void main(String[] args) {
        StoneGame s = new StoneGame();
        Utils.print(s.stoneGame(new int[]{3, 9, 1, 2}));
        Utils.print(s.stoneGame(new int[]{5, 3, 4, 5}));
    }

    public boolean stoneGame(int[] piles) {
        final int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 初始化i==j的情况
            dp[i][i] = piles[i];
        }
        // 从后往前遍历，是因为需要dp[i][j] 需要依赖dp[i+1][j]
        for (int i = n - 2; i >= 0; i--) {
            // 从前往后遍历，是因为需要dp[i][j] 需要依赖dp[i][j-1]
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        // 从头到尾，Alice与Bob的得分差是都大于0
        return dp[0][n - 1] > 0;
    }
}
