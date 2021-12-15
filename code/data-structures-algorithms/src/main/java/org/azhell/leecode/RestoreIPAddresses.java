package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 回溯法
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        Utils.print(restoreIPAddresses.restoreIpAddresses("25525511135"));
        Utils.print(restoreIPAddresses.restoreIpAddresses("0000"));
        Utils.print(restoreIPAddresses.restoreIpAddresses("010010"));
        Utils.print(restoreIPAddresses.restoreIpAddresses("101023"));
    }

    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        restoreIpAddresses(s, "", 0);
        return result;
    }

    public void restoreIpAddresses(String s, String ip, int index) {
        if (index == 3 && isInValidRange(s)) {
            ip += s;
            result.add(ip);
        } else {
            for (int i = 1; i <= Math.min(s.length(), 3); i++) {
                String substring = s.substring(0, i);
                if (isInValidRange(substring) && s.length() - i >= (3 - index) && s.length() - i <= 3 * (3 - index)) {
                    index += 1;
                    restoreIpAddresses(s.substring(i), ip + substring + ".", index);
                    index -= 1;
                }
            }
        }
    }

    private boolean isInValidRange(String s) {
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        } else {
            int i = Integer.parseInt(s);
            return i >= 0 && i <= 255;
        }
    }
}
