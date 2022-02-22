package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 前缀和 + hash
 * sum[i] = sum[i-1] + arr[i]
 * i到j的子数组和为 sum[i] - sum[j]
 * sum[j] - sum[i] = k的变种公式为
 * sum[i] = sum[j] - k 这里就是哈希算法的关键
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        Utils.print(s.subarraySum(new int[]{1, 1, 1}, 2));
        Utils.print(s.subarraySum(new int[]{1, 2, 3}, 3));
        Utils.print(s.subarraySum(new int[]{1, -1, 0}, 0));
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 计算前缀和
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int sum : sums) {
            if (sum == k) {
                ans += 1;
            }
            // 防止有k为0的情况，所以这里两个条件都要判断
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.computeIfAbsent(sum, key -> 0) + 1);
        }
        return ans;
    }
}
