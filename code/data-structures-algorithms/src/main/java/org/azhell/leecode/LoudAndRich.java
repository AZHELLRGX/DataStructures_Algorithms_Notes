package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 851. 喧闹和富有
 * 拓扑排序是图论中很重要的知识点
 * 关于图的存储数据结构：1、邻接矩阵【二维数组】 2、邻接表【链表】
 * 本题采用邻接矩阵解题
 * 关于拓扑排序：
 * 起始时，每个 ans[i] = i，然后将统计入度为 0 的节点进行入队，每次出队时，将该节点删掉，
 * 对该 DAG 带来影响是「该节点的邻点的入度减一」，若更新入度后数值为 0，则将该邻点进行入队操作。
 * <p>
 * 具体到本题：
 * 同时，利用跑拓扑排序过程中的 t -> u关系，尝试使用 ans[t]更新 ans[u]（由于存在 t 指向 u 的边，
 * 说明 t 比 u 有钱，此时检查两者的安静值，若满足 quiet[ans[t]] < quiet[ans[u]]，则用 ans[t]更新 ans[u]）。
 *
 * 参考文章
 * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247489706&idx=1&sn=771cd807f39d1ca545640c0ef7e5baec&chksm=fd9cb3b5caeb3aa333809633f09e3967c8f62d10feec5a463c7e30d4781e1fecb50e7f46e4af&token=126965152&lang=zh_CN#rd
 * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488007&idx=1&sn=9d0dcfdf475168d26a5a4bd6fcd3505d&chksm=fd9cb918caeb300e1c8844583db5c5318a89e60d8d552747ff8c2256910d32acd9013c93058f&token=126965152&lang=zh_CN#rd
 *
 */
public class LoudAndRich {
    public static void main(String[] args) {
        LoudAndRich loudAndRich = new LoudAndRich();
        int[][] richer = new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = new int[]{3, 2, 5, 4, 6, 1, 7, 0};
        Utils.print(loudAndRich.loudAndRich(richer, quiet));
    }

    // 因为是自然数，所以不需要单独试用一维数据进行维护
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        // 构建邻接矩阵
        int[][] matrix = new int[n][n];
        // 节点入度
        int[] in = new int[n];
        for (int[] twoEle : richer) {
            int a = twoEle[0];
            int b = twoEle[1];
            matrix[a][b] = 1;
            in[b] += 1;
        }
        // 构建一个队列
        Deque<Integer> deque = new ArrayDeque<>(n);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;// 初始化每个富人本身为最安静的
            // 如果这个节点入度为0，则加入队列
            if (in[i] == 0)
                deque.addLast(i);
        }
        while (!deque.isEmpty()) {
            // 拿出一个节点
            Integer i = deque.pollFirst();
            // 看看这个节点是否指向另外一个节点
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    // 可以确定的是富人i一定比j有钱，需要额外对比安静值
                    // 这里对比的是比j有钱且安静的富人中，最安静的那个，quite值越小越安静
                    if (quiet[ans[i]] < quiet[ans[j]])
                        // 更新值，因为富人i比j更有钱，且更安静
                        ans[j] = ans[i];
                    if (--in[j] == 0)
                        deque.addLast(j);
                }
            }
        }
        return ans;
    }
}
