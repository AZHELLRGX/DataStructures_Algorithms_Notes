package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 05. 替换空格
 */
public class Offer05 {
    public static void main(String[] args) {
        Offer05 o = new Offer05();
        Utils.print(o.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        if (s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
