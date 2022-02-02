package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15.三数之和
 * 排序、双指针解法；第二次使用到双指针
 */
public class Q3Sum {

    public static void main(String[] args) {
        Q3Sum q3Sum = new Q3Sum();
        Utils.print(q3Sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        Utils.print(q3Sum.threeSumOld(new int[]{-1, 0, 1, 2, -1, -4}));
        Utils.print(q3Sum.threeSum(new int[]{0, 0, 0}));
        Utils.print(q3Sum.threeSumOld(new int[]{0, 0, 0}));
        Utils.print(q3Sum.threeSum(new int[]{0}));
        Utils.print(q3Sum.threeSumOld(new int[]{0}));
        Utils.print(q3Sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
        Utils.print(q3Sum.threeSumOld(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
        Utils.print(q3Sum.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
        Utils.print(q3Sum.threeSumOld(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));

    }

    // 优化后的方案 去重方案使用三个临时变量
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int curNum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (curNum != nums[i] && nums[i] <= 0) {
                int l = i + 1;
                int r = n - 1;
                int lNum = Integer.MAX_VALUE;
                int rNum = Integer.MAX_VALUE;
                while (l < r) {
                    int ans = nums[l] + nums[r] + nums[i];
                    if (ans == 0) {
                        if (nums[l] != lNum && nums[r] != rNum)
                            result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        lNum = nums[l];
                        rNum = nums[r];
                        l++;
                        r--;
                    } else if (ans > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
                curNum = nums[i];
            }
        }
        return result;
    }


    // 过去的旧方案，需要优化
    private List<List<Integer>> threeSumOld(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }

        // 需要先排序，非重点
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        // 如果最大的数据是0，那么需要凑齐三个0
        if (nums[0] == 0) {
            int num0Count = 1;
            for (int k = 1; k < nums.length; k++) {
                if (nums[k] == 0) {
                    num0Count++;
                }
            }
            if (num0Count >= 3) {
                result.add(Arrays.asList(0, 0, 0));
                return result;
            }
        }

        // 挑选第一个数x，然后使用双指针从头到位抽取满足与x相加等于0的数据
        int lastNum = 0;
        String lastString = "";
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < 0) {
                break;
            }
            if (lastNum == nums[k]) {
                // 如果这个数据之前已经找过了，就不需要再找一次
                continue;
            } else {
                lastNum = nums[k];
            }
            int i = k + 1; // 从当前数据的下一位开始找起
            int j = nums.length - 1;
            while (i < j) {
                int temp = nums[i] + nums[j];
                if (temp == -nums[k]) {
                    String curString = "" + nums[k] + nums[i] + nums[j];
                    if (!lastString.equals(curString)) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        lastString = curString;
                    }
                    i++;
                    j--;
                } else if (temp > -nums[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }

}
