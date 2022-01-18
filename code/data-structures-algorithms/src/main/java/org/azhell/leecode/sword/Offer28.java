package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 无它，还是递归
 */
public class Offer28 {
    public static void main(String[] args) {
        Offer28 o = new Offer28();
        TreeNode root = Utils.initTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        Utils.print(o.isSymmetric(root));
        root = Utils.initTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3});
        Utils.print(o.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            // 根据测试用例194, 空二叉树也是对称二叉树
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val == right.val) {
                return isSymmetricHelper(left.left, right.right) &&
                        isSymmetricHelper(left.right, right.left);
            } else {
                return false;
            }
        }
        return false;
    }
}
