package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1332. 删除回文子序列
 * 本题删除的是回文子序列，不是子串，所以最多需要删除两次，例如先删除所有的a，再删除所有的b
 * 只有一种情况会删除一次，那就是整个字符串就是一个回文串
 */
public class RemovePalindromicSubsequences {
    public static void main(String[] args) {
        RemovePalindromicSubsequences r = new RemovePalindromicSubsequences();
        Utils.print(r.removePalindromeSub("ababa"));
        Utils.print(r.removePalindromeSub("abb"));
        Utils.print(r.removePalindromeSub("baabb"));
    }

    public int removePalindromeSub(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return 2;
            i++;
            j--;
        }
        return 1;
    }
}
