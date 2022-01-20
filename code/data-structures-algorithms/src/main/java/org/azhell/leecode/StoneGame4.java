package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 2029. 石子游戏 IX
 * 博弈问题
 * todo 不会做，大部分博弈问题目前不是我这个层次的智商可以分析出来的
 * 所有的博弈问题等我逻辑思维能力到了一定层次再回来看
 */
public class StoneGame4 {
    public static void main(String[] args) {
        StoneGame4 s = new StoneGame4();
        Utils.print(s.stoneGameIX(new int[]{5, 1, 2, 4, 3}));
    }

    public boolean stoneGameIX(int[] stones) {
        int[] s = new int[3];
        for (int i : stones) ++s[i % 3];
        if (s[0] % 2 == 0) return s[1] != 0 && s[2] != 0;
        return Math.abs(s[1] - s[2]) > 2;
    }
}
