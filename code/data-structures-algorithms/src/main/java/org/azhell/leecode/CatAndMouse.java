package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 913. 猫和老鼠
 * 博弈问题
 * 这道题不是建立在数组的博弈问题，所以难度很大
 * 还是动态规划解题
 * todo 直接CV！！ 做不出来，我很抱歉
 */
public class CatAndMouse {
    public static void main(String[] args) {
        CatAndMouse c = new CatAndMouse();
        Utils.print(c.catMouseGame(new int[][]{
                {2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}
        }));
        Utils.print(c.catMouseGame(new int[][]{{1, 3}, {0}, {3}, {0, 2}}));
    }

    static final int MOUSE_WIN = 1;
    static final int CAT_WIN = 2;
    static final int DRAW = 0;
    int n;
    int[][] graph;
    int[][][] dp;

    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        this.dp = new int[n][n][n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getResult(1, 2, 0);
    }

    /**
     * @param mouse 老鼠当前所在点
     * @param cat   猫当前所在点
     * @param turns 回合数
     * @return 结果
     */
    public int getResult(int mouse, int cat, int turns) {
        if (turns == n * 2) {
            return DRAW;
        }
        if (dp[mouse][cat][turns] < 0) {
            if (mouse == 0) {
                dp[mouse][cat][turns] = MOUSE_WIN;
            } else if (cat == mouse) {
                dp[mouse][cat][turns] = CAT_WIN;
            } else {
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }

    /**
     * @param mouse 老鼠当前所在点
     * @param cat   猫当前所在点
     * @param turns 回合数
     */
    public void getNextResult(int mouse, int cat, int turns) {
        // 老鼠是先手，偶数回合动【第一回合是0】
        int curMove = turns % 2 == 0 ? mouse : cat;
        int defaultResult = curMove == mouse ? CAT_WIN : MOUSE_WIN;
        int result = defaultResult;
        int[] nextNodes = graph[curMove];
        for (int next : nextNodes) {
            if (curMove != cat || next != 0) {
                int nextMouse = curMove == mouse ? next : mouse;
                int nextCat = curMove == cat ? next : cat;
                int nextResult = getResult(nextMouse, nextCat, turns + 1);
                if (nextResult != defaultResult) {
                    result = nextResult;
                    if (result != DRAW) {
                        break;
                    }
                }
            }
        }
        dp[mouse][cat][turns] = result;
    }
}
