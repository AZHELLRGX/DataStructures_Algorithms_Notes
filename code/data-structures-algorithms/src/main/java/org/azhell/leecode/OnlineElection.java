package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 911. 在线选举
 * 采用二分法
 * 采用Hash表记录每个time的候选人以及候选人票
 * 查找时刻的时候，首先在times数组中找到最近的时间，然后去hash表找出对应时刻的投票状态
 */
public class OnlineElection {
    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        int[] array = new int[]{3, 12, 25, 15, 24, 8};
        for (int a : array) {
            Utils.print(topVotedCandidate.q(a));
        }
        //  [[[0,1,2,2,1],[20,28,29,54,56]],[28],[53],[57],[29],[29],[28],[30],[20],[56],[55]]
        TopVotedCandidate topVotedCandidate1 = new TopVotedCandidate(new int[]{0, 1, 2, 2, 1}, new int[]{20, 28, 29, 54, 56});
        array = new int[]{28, 53, 57, 29, 29, 28, 30, 20, 56, 55};
        for (int a : array) {
            Utils.print(topVotedCandidate1.q(a));
        }
    }

    static class TopVotedCandidate {
        int[] persons;
        int[] times;
        // 记录上一时刻得票情况
        Map<Integer, Integer> personTicketMap;
        int[] winPersons;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.persons = persons;
            this.times = times;
            personTicketMap = new HashMap<>();
            winPersons = new int[times.length];
            for (int i = 0; i < times.length; i++) {
                // 当前时刻得票人详情
                int person = persons[i];
                personTicketMap.put(person, personTicketMap.computeIfAbsent(person, key -> 0) + 1);
                judgeWin(person, i);
            }
        }

        // 判断某一时刻的获胜者
        public void judgeWin(int person, int index) {
            if (index == 0) {
                winPersons[0] = person;
                return;
            }
            // 要么新来的获胜者赢，要么就是上一轮的获胜者继续赢
            int winPerson = winPersons[index - 1];
            if (personTicketMap.get(person) >= personTicketMap.get(winPerson)) {
                winPerson = person;
            }
            winPersons[index] = winPerson;
        }

        public int q(int t) {
            if (t >= times[times.length - 1]) {
                return winPersons[winPersons.length - 1];
            }
            // 二分查找比当前时刻小，且最接近的时间
            int left = 0;
            int right = times.length - 1;
            while (left + 1 < right) {
                int mid = (right + left) / 2;
                if (times[mid] == t) {
                    return winPersons[mid];
                } else if (times[mid] > t) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return winPersons[left];
        }
    }

}
