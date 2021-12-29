package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1995. 统计特殊四元组
 */
public class CountSpecialQuadruplets {
    public static void main(String[] args) {
        CountSpecialQuadruplets c = new CountSpecialQuadruplets();
        Utils.print(c.countQuadruplets(new int[]{1, 2, 3, 6}));
        Utils.print(c.countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        Utils.print(c.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
    }

    public int countQuadruplets(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int a = k + 1; a < nums.length; a++) {
                        if (nums[i] + nums[j] + nums[k] == nums[a]) {
                            ans += 1;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
