package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 748. 最短补全词
 * 哈希表
 */
public class ShortestCompletingWord {
    public static void main(String[] args) {
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        Utils.print(shortestCompletingWord.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        Utils.print(shortestCompletingWord.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
        Utils.print(shortestCompletingWord.shortestCompletingWord("Ah71752", new String[]{"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"}));
        Utils.print(shortestCompletingWord.shortestCompletingWord("OgEu755", new String[]{"enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus"}));
        Utils.print(shortestCompletingWord.shortestCompletingWord("iMSlpe4", new String[]{"claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"}));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        int charCnt = 0;
        for (int i = 0; i < licensePlate.length(); i++) {
            char temp = licensePlate.charAt(i);
            if (temp >= 'A') {
                if (temp < 'a') {
                    temp = (char) (temp + 32);
                }
                charCnt += 1;
                map.put(temp, map.computeIfAbsent(temp, key -> 0) + 1);
            }
        }
        // 不断的减map里面的元素个数，直到cnt等于0
        int minLength = Integer.MAX_VALUE;
        String minWord = "";
        for (String word : words) {
            if (word.length() < minLength && word.length() >= charCnt) {
                int tempCnt = charCnt;
                Map<Character, Integer> tempMap = new HashMap<>(map);
                for (int j = 0; j < word.length(); j++) {
                    char temp = word.charAt(j);
                    if (tempMap.containsKey(temp) && tempMap.get(temp) >= 1) {
                        tempMap.put(temp, tempMap.get(temp) - 1);
                        tempCnt -= 1;
                    }
                    if (tempCnt == 0) {
                        minLength = word.length();
                        minWord = word;
                        break;
                    }
                }
            }
            if (minWord.length() == charCnt){
                return minWord;
            }
        }
        return minWord;
    }
}
