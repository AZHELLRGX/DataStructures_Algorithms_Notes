package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 383. 赎金信
 * 首先想到的还是哈希表解题
 * 但是因为数据全是字母，所以只需要构建一个26位的数组即可
 */
public class RansomNote {
    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        Utils.print(ransomNote.canConstruct("a", "b"));
        Utils.print(ransomNote.canConstruct("aa", "ab"));
        Utils.print(ransomNote.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineArray = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            final int k = magazine.charAt(i) - 'a';
            magazineArray[k] = magazineArray[k] + 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            final int k = ransomNote.charAt(i) - 'a';
            if (magazineArray[k] >= 1) {
                magazineArray[k] = magazineArray[k] - 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
