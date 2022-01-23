package org.azhell.leecode.competition.weekly;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 第277场周赛
 * 第四题做不出来我很抱歉
 */
public class W277 {

    public static void main(String[] args) {
        W277 s = new W277();
        Utils.print(s.countElements(new int[]{11, 7, 2, 15}));
        Utils.print(s.countElements(new int[]{-3, 3, 3, 90}));
        Utils.print(s.countElements(new int[]{-3, -3, -2, 3, 90, 91}));
        Utils.print(s.countElements(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));

        Utils.print(s.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4}));
        Utils.print(s.rearrangeArray(new int[]{-1, 1}));

        Utils.print(s.findLonely(new int[]{10, 6, 5, 8}));
        Utils.print(s.findLonely(new int[]{1, 3, 5, 3}));
    }

    // 5989. 元素计数
    public int countElements(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i++;
        }
        int j = nums.length - 1;
        while (j > 1) {
            if (nums[j] > nums[j - 1]) {
                break;
            }
            j--;
        }
        if (j > i + 1)
            return j - i - 1;
        else return 0;
    }

    // 5991. 按符号重排数组
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        int[] zNums = new int[half];
        int[] fNums = new int[half];
        int i = 0;
        int j = 0;
        for (int num : nums) {
            if (num < 0) {
                fNums[j++] = num;
            } else {
                zNums[i++] = num;
            }
        }
        i = 0;
        j = 0;
        for (int k = 0; k < n; k++) {
            if (k % 2 != 0) {
                nums[k] = fNums[j++];
            } else {
                nums[k] = zNums[i++];
            }
        }
        return nums;
    }

    // 5990. 找出数组中的所有孤独数字
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.computeIfAbsent(num, key -> 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && !map.containsKey(entry.getKey() - 1)
                    && !map.containsKey(entry.getKey() + 1)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    // 5992. 基于陈述统计最多好人数
    public int maximumGood(int[][] statements) {
        // 如果A说B是好人，那么A和B要么都是好人要么都是坏人
        // 如果A说B是坏人，那么A和B只有一个是好人
        // 维护一个并查集
        return 0;
    }
}
