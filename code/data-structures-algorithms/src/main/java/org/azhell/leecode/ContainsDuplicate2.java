package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * 使用哈希表解题，每个元素只需要存储最新的位置即可
 */
public class ContainsDuplicate2 {
    public static void main(String[] args) {
        ContainsDuplicate2 c = new ContainsDuplicate2();
        Utils.print(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        Utils.print(c.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        Utils.print(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        Utils.print(c.containsNearbyDuplicate(new int[]{1, 2, 1}, 0));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0 || nums.length == 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
