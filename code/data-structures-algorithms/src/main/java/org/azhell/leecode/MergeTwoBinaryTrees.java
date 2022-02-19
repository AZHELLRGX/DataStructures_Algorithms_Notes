package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 617. 合并二叉树
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        MergeTwoBinaryTrees m = new MergeTwoBinaryTrees();
        final TreeNode root1 = Utils.initTreeNode(new Integer[]{1, 3, 2, 5});
        final TreeNode root2 = Utils.initTreeNode(new Integer[]{2, 1, 3, null, 4, null, 7});
        final TreeNode newTree = m.mergeTrees(root1, root2);
        Utils.print(newTree);
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode newTree = new TreeNode();
        if (root1 != null) {
            if (root2 != null) {
                newTree.val = root1.val + root2.val;
                newTree.left = mergeTrees(root1.left, root2.left);
                newTree.right = mergeTrees(root1.right, root2.right);
            } else {
                newTree.val = root1.val;
                newTree.left = mergeTrees(root1.left, null);
                newTree.right = mergeTrees(root1.right, null);
            }
        } else {
            newTree.val = root2.val;
            newTree.left = mergeTrees(null, root2.left);
            newTree.right = mergeTrees(null, root2.right);
        }
        return newTree;
    }
}
