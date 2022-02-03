package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 572. 另一棵树的子树
 * 三种情况
 * 1、与当前树相等
 * 2、与当前树的左子树相等
 * 3、与当前树的右子树相等
 */
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        SubtreeOfAnotherTree s = new SubtreeOfAnotherTree();
        TreeNode root = Utils.initTreeNode(new Integer[]{3, 4, 5, 1, 2});
        TreeNode subRoot = Utils.initTreeNode(new Integer[]{4, 1, 2});
        Utils.print(s.isSubtree(root, subRoot));
        root = Utils.initTreeNode(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
        Utils.print(s.isSubtree(root, subRoot));
        root = Utils.initTreeNode(new Integer[]{1, 1});
        subRoot = Utils.initTreeNode(new Integer[]{1});
        Utils.print(s.isSubtree(root, subRoot));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return equal(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean equal(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else {
            if (a.val == b.val) return equal(a.left, b.left) && equal(a.right, b.right);
            else return false;
        }
    }
}
