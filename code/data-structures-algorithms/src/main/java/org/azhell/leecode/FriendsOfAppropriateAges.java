package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.Arrays;

/**
 * 825. 适龄的朋友
 * 排序 + 双指针
 */
public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        FriendsOfAppropriateAges f = new FriendsOfAppropriateAges();
        Utils.print(f.numFriendRequests(new int[]{16, 16}));
        Utils.print(f.numFriendRequestsForX(new int[]{16, 16, 16}));
        Utils.print(f.numFriendRequests(new int[]{16, 17, 18}));
        Utils.print(f.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
        Utils.print(f.numFriendRequests(new int[]{118, 14, 7, 63, 103}));
    }

    // 着眼与y，判断有多少个x可以发送消息
    // 代码的设计感还是太差，害
    public int numFriendRequests(int[] ages) {
        // 两个不等式需要同时满足 y > 0.5x + 7 且 y <= x; 第三个条件一样无需考虑
        // 因为y <= x，所以排序后，只能往后找x
        // 随着y的增大，在当前y所在位置到right位置的元素依旧满足y > 0.5x + 7，所以右指针继续右移即可
        Arrays.sort(ages);
        int left = 0;
        int right = 0;
        int sum = 0;
        // 记录上一个重复值对应的sum
        int lastSum = 0;
        while (left < ages.length) {
            if (left != 0 && ages[left] == ages[left - 1]) {
                sum += lastSum;
            } else {
                while (right < ages.length && ages[left] > ages[right] * 0.5 + 7) {
                    right++;
                }
                if (right != left) {
                    lastSum = right - left - 1;
                    sum += lastSum;
                }
            }
            left++;
            right = Math.max(right, left);
        }
        return sum;
    }

    // 着眼与x，判断x能发送的好友请求数【超时，GG】
    public int numFriendRequestsForX(int[] ages) {
        Arrays.sort(ages);
        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            // 因为存在限制条件age[y] < age[x]，所以从0找到i即可
            // 左指针找第一个满足 age[y] > 0.5 * age[x] + 7 的位置
            // 第三个条件其实排序后根本不会为真
            // 右指针找与当前元素相同的数据，当前需要先满足age[y] > 0.5 * age[x] + 7
            int age = ages[i];
            int j = 0;
            while (j < i && ages[j] <= 0.5 * age + 7) {
                j++;
            }
            if (i + 1 < ages.length && age > 0.5 * age + 7) {
                int k = i + 1;
                while (k < ages.length && ages[k] == age) {
                    sum++;
                    k++;
                }
            }
            sum += i - j;
        }
        return sum;
    }
}
