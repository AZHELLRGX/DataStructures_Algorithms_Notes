package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 题目没说不能在原树上改，递归交换左右子树即可
 */
public class Offer27 {
    public static void main(String[] args) {
        Offer27 o = new Offer27();
        final TreeNode root = Utils.initTreeNode(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        Utils.print(o.mirrorTree(root));
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        exchange(root);
        return root;
    }

    private void exchange(TreeNode root) {
        if (root.left != null)
            exchange(root.left);
        if (root.right != null)
            exchange(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
