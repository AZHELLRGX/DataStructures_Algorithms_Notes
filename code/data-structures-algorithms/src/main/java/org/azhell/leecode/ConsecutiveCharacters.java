package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1446. 连续字符
 */
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        ConsecutiveCharacters consecutiveCharacters = new ConsecutiveCharacters();
        Utils.print(consecutiveCharacters.maxPower("leetcode"));
        Utils.print(consecutiveCharacters.maxPower("abbcccddddeeeeedcba"));
        Utils.print(consecutiveCharacters.maxPower("triplepillooooow"));
        Utils.print(consecutiveCharacters.maxPower("hooraaaaaaaaaaay"));
        Utils.print(consecutiveCharacters.maxPower("tourist"));
        Utils.print(consecutiveCharacters.maxPower("j"));
        Utils.print(consecutiveCharacters.maxPower("cc"));
    }

    public int maxPower(String s) {
        int maxCount = 0;
        char currentChar = s.charAt(0);
        int currentCount = 1;
        // 直接从头到尾检索
        for (int i = 1; i < s.length(); i++) {
            if (currentChar != s.charAt(i)) {
                maxCount = Math.max(maxCount, currentCount);
                currentChar = s.charAt(i);
                currentCount = 1;
            } else {
                currentCount++;
            }
        }
        return Math.max(maxCount, currentCount);
    }
}
