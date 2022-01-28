package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 1996. 游戏中弱角色的数量
 * 先按照攻击力降序排序，然后防御力升序排序
 * 再次遍历的时候，如果出现了防御力高于自己的角色，自己则是弱角色
 * 所以需要维护一个防御力的阶段性最大值
 * 其实就是一种贪心算法
 * 这种题需要记住解题套路
 */
public class TheNumberOfWeakCharactersInTheGame {
    public static void main(String[] args) {
        TheNumberOfWeakCharactersInTheGame t = new TheNumberOfWeakCharactersInTheGame();
        Utils.print(t.numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}));
        Utils.print(t.numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}));
        Utils.print(t.numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}));
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        int max = -1;
        int cnt = 0;
        for (int[] property : properties) {
            if (max > property[1]) {
                cnt += 1;
            } else {
                max = property[1];
            }
        }
        return cnt;
    }
}
