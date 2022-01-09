package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1629. 按键持续时间最长的键
 * 这题很容易理解错意思，需要仔细阅读题目以及查看测试用例验证自己的理解
 * 陷阱蛮多的哈哈
 */
public class SlowestKey {
    public static void main(String[] args) {
        SlowestKey s = new SlowestKey();
        Utils.print(s.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        Utils.print(s.slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
        Utils.print(s.slowestKey(new int[]{28, 65, 97}, "gaf"));
        Utils.print(s.slowestKey(new int[]{1, 2}, "ba"));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char slowestKey = keysPressed.charAt(0);
        for (int i = 1; i < keysPressed.length(); i++) {
            int tempTime = releaseTimes[i] - releaseTimes[i - 1];
            char tempKey = keysPressed.charAt(i);
            if (tempTime > maxTime || (tempTime == maxTime && tempKey > slowestKey)) {
                slowestKey = tempKey;
                maxTime = tempTime;
            }
        }
        return slowestKey;
    }
}
