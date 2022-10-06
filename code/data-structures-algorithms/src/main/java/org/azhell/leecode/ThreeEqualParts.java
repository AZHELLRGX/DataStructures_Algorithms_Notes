package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 927. 三等分
 * 这道题是模拟题，一开始自己是没什么思路的，全靠题解给的思路
 * <a href="https://leetcode.cn/problems/three-equal-parts/solution/san-deng-fen-by-leetcode-solution-3l2y/">https://leetcode.cn/problems/three-equal-parts/solution/san-deng-fen-by-leetcode-solution-3l2y/</a>
 */
public class ThreeEqualParts {
    public static void main(String[] args) {
        ThreeEqualParts t = new ThreeEqualParts();
        Utils.print(t.threeEqualParts(new int[]{1, 0, 1, 0, 1}));
        Utils.print(t.threeEqualParts(new int[]{1, 1, 0, 1, 1}));
        Utils.print(t.threeEqualParts(new int[]{1, 1, 0, 0, 1}));
    }

    public int[] threeEqualParts(int[] arr) {
        int cnt = 0;
        for (int i : arr) {
            if (1 == i) cnt += 1;
        }
        if (cnt == 0) return new int[]{0, 2};
        if (cnt % 3 != 0) return new int[]{-1, -1};
        int partial = cnt / 3;
        int index = 0;
        int first = -1;
        int second = -1;
        int third = -1;
        for (int i = 0; i < arr.length; i++) {
            if (1 == arr[i]) index += 1;
            if (first == -1 && index == 1) first = i;
            if (second == -1 && index == partial + 1) second = i;
            if (index == 2 * partial + 1) {
                third = i;
                break;
            }
        }
        int len = arr.length - third;
        if (first + len > second || second + len > third) {
            return new int[]{-1, -1};
        }
        for (int i = 0; i < len; i++) {
            if (arr[first + i] != arr[second + i] ||
                    arr[third + i] != arr[second + i] ||
                    arr[first + i] != arr[third + i]) {
                return new int[]{-1, -1};
            }
        }
        return new int[]{first + len - 1, second + len};
    }
}
