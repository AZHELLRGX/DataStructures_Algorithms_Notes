package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 这道题的思路就是不断的用根节点来判断
 * 根节点左侧必须全小于根  右侧必须全大于根
 * 只要出现了错误那么就不对
 */
public class Offer33 {
    public static void main(String[] args) {
        Offer33 o = new Offer33();
        Utils.print(o.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        Utils.print(o.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        Utils.print(o.verifyPostorder(new int[]{1, 3, 2, 5, 7, 6, 4}));
        Utils.print(o.verifyPostorder(new int[]{1, 3, 2, 5, 6, 7, 4}));
    }

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int split = start;
        for (int i = end; i > start; i--) {
            if (postorder[i] < root) {
                split = i;
                break;
            }
        }
        // 判断从start到split的数据是否全部小于end
        for (int i = start; i < split; i++) {
            if (postorder[i] > root) {
                return false;
            }
        }
        return verifyPostorder(postorder, start, split) && verifyPostorder(postorder, split + 1, end - 1);
    }
}
