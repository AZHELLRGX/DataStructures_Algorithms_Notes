package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 1036. 逃离大迷宫
 * <p>
 * 如果网格很小比较简单，就和第二题一样，通过深搜或广搜，看是否能到达终点T即可。但是网格空间太大了。直接搜肯定超时。
 * 可以从最多200个点来思考。到不了的情况就是S或T被这200个点给围住了。只要能判断是否被围住就可以了。
 * 原题200个点是在最下面数据范围里写的，很隐藏，很难注意到。
 * 怎么判断S或T被障碍点围住呢？
 * 找到200个点能够围住的最大范围包括的点数Total，从S广搜，如果已经搜到Total个空白点，还有路可走，那么这200个点肯定包围不了S点。
 * 同理再判断下是否有包围住T点，两个都没被包围，则一定能走到。
 * 当然，也可能两个点都被包围了，那么在搜的时候判断能直达，直接返回true就可以了。
 * n * (n-1) / 2
 * 200个点能够包围的最大空白部分是多少？答案是19900=(200-1)*200/2。
 */
public class EscapeALargeMaze {
    public static void main(String[] args) {
        EscapeALargeMaze e = new EscapeALargeMaze();
        Utils.print(e.isEscapePossible(new int[][]{{0, 1}, {1, 0}}, new int[]{0, 0}, new int[]{0, 2}));
        Utils.print(e.isEscapePossible(new int[][]{{100059, 100063}, {100060, 100064}, {100061, 100065}, {100062, 100066}, {100063, 100067}, {100064, 100068}, {100065, 100069}, {100066, 100070}, {100067, 100071}, {100068, 100072}, {100069, 100073}, {100070, 100074}, {100071, 100075}, {100072, 100076}, {100073, 100077}, {100074, 100078}, {100075, 100079}, {100076, 100080}, {100077, 100081}, {100078, 100082}, {100079, 100083}, {100080, 100082}, {100081, 100081}, {100082, 100080}, {100083, 100079}, {100084, 100078}, {100085, 100077}, {100086, 100076}, {100087, 100075}, {100088, 100074}, {100089, 100073}, {100090, 100072}, {100091, 100071}, {100092, 100070}, {100093, 100069}, {100094, 100068}, {100095, 100067}, {100096, 100066}, {100097, 100065}, {100098, 100064}, {100099, 100063}, {100098, 100062}, {100097, 100061}, {100096, 100060}, {100095, 100059}, {100094, 100058}, {100093, 100057}, {100092, 100056}, {100091, 100055}, {100090, 100054}, {100089, 100053}, {100088, 100052}, {100087, 100051}, {100086, 100050}, {100085, 100049}, {100084, 100048}, {100083, 100047}, {100082, 100046}, {100081, 100045}, {100080, 100044}, {100079, 100043}, {100078, 100044}, {100077, 100045}, {100076, 100046}, {100075, 100047}, {100074, 100048}, {100073, 100049}, {100072, 100050}, {100071, 100051}, {100070, 100052}, {100069, 100053}, {100068, 100054}, {100067, 100055}, {100066, 100056}, {100065, 100057}, {100064, 100058}, {100063, 100059}, {100062, 100060}, {100061, 100061}, {100060, 100062}},
                new int[]{100079, 100063}, new int[]{999948, 999967}));
    }

    int maxPointCnt;
    Set<String> blockedSet;
    Set<String> resultPoints;
    int[] t;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;
        if (n == 0) {
            return true;
        }
        this.maxPointCnt = n * (n - 1) / 2;
        // Java数据的初始容量非常重要
        this.blockedSet = new HashSet<>(blocked.length);
        for (int[] b : blocked) {
            blockedSet.add(b[0] + "_" + b[1]);
        }
        t = target;
        // Java数据的初始容量非常重要 十倍的内存差距
        resultPoints = new HashSet<>(maxPointCnt + 1);
        if (dfs(source[0], source[1])) {
            t = source;
            resultPoints.clear();
            return dfs(target[0], target[1]);
        } else {
            return false;
        }
    }

    // 搜索
    private boolean dfs(int i, int j) {
        if (resultPoints.size() > maxPointCnt) {
            return true;
        } else {
            if (i == t[0] && j == t[1]) {
                return true;
            } else if (canContinue(i, j)) {
                return dfs(i + 1, j) ||
                        dfs(i - 1, j) ||
                        dfs(i, j + 1) ||
                        dfs(i, j - 1);
            } else {
                return false;
            }
        }
    }

    // 是否还可以继续搜索
    private boolean canContinue(int i, int j) {
        if (i >= 0 && i < 1000000 && j >= 0 && j < 1000000) {
            String s = i + "_" + j;
            if (!blockedSet.contains(s)) {
                return resultPoints.add(s);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
