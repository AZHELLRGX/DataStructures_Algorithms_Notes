package org.azhell.leecode;


import org.azhell.tool.Utils;

import java.util.*;

/**
 * 870. 优势洗牌
 * 1、排序 + 双指针  缺点：内存消耗比较大
 * 2、贪心算法   后续有时间探索解法
 */
public class AdvantageShuffle {
    public static void main(String[] args) {
        AdvantageShuffle a = new AdvantageShuffle();
        Utils.print(a.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}));
        Utils.print(a.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11}));
        Utils.print(a.advantageCount(new int[]{5621, 1743, 5532, 3549, 9581}, new int[]{913, 9787, 4121, 5039, 1481}));
        Utils.print(a.advantageCount(new int[]{718967141, 189971378, 341560426, 23521218, 339517772}, new int[]{967482459, 978798455, 744530040, 3454610, 940238504}));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] result = new int[len];
        Arrays.sort(nums1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            List<Integer> list = map.computeIfAbsent(nums2[i], key -> new ArrayList<>());
            list.add(i);
        }
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            if (nums1[i] > nums2[j]) {
                List<Integer> list = map.get(nums2[j]);
                result[list.remove(0)] = nums1[i];
                if (list.isEmpty()) map.remove(nums2[j]);
                nums1[i] = 0;
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        if (j < len) {
            i = 0;
            for (int k = 0; k < result.length; k++) {
                if (result[k] == 0) {
                    while (i < len) {
                        if (nums1[i] != 0) {
                            result[k] = nums1[i];
                            i++;
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return result;
    }
}
