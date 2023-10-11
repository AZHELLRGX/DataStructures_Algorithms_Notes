package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 2512. 奖励最顶尖的 K 名学生
 */
public class Q2512 {
    public static void main(String[] args) {
        String[] positiveFeedback = new String[]{"smart", "brilliant", "studious"};
        String[] negativeFeedback = new String[]{"not"};
        String[] report = new String[]{"this student is studious", "the student is smart"};
        int[] studentId = new int[]{1, 2};
        Utils.print(Q2512.topStudents(positiveFeedback, negativeFeedback, report, studentId, 2));
    }

    public static List<Integer> topStudents(String[] positiveFeedback, String[] negativeFeedback, String[] report, int[] studentId, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : positiveFeedback) {
            map.put(s, 3);
        }
        for (String s : negativeFeedback) {
            map.put(s, -1);
        }
        int n = report.length;
        int[][] scoreStudent = new int[n][2];
        for (int i = 0; i < n; i++) {
            int score = 0;
            String s = report[i];
            String[] words = s.split(" ");
            for (String word : words) {
                score += map.getOrDefault(word, 0);
            }
            scoreStudent[i] = new int[]{score, studentId[i]};
        }
        Arrays.sort(scoreStudent, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(scoreStudent[i][1]);
        }
        return result;
    }
}
