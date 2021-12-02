package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. 相对名次
 * 20211202每日一题
 * 无脑哈希表
 */
public class RelativeRanks {
    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        Utils.print(relativeRanks.findRelativeRanks(new int[]{5, 4, 3, 2, 1}));
        Utils.print(relativeRanks.findRelativeRanks(new int[]{10, 3, 8, 9, 4}));
    }

    public String[] findRelativeRanks(int[] score) {
        final int[] newArray = Arrays.copyOf(score, score.length);
        Arrays.sort(newArray);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = newArray.length - 1; i >= 0; i--) {
            map.put(newArray[i], newArray.length - i);
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            final Integer rank = map.get(score[i]);
            // "Gold Medal","Silver Medal","Bronze Medal"
            switch (rank) {
                case 1:
                    result[i] = "Gold Medal";
                    break;
                case 2:
                    result[i] = "Silver Medal";
                    break;
                case 3:
                    result[i] = "Bronze Medal";
                    break;
                default:
                    result[i] = String.valueOf(rank);
                    break;
            }
        }
        return result;
    }
}
