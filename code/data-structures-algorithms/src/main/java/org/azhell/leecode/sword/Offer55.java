package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * 110. 平衡二叉树
 * 本题主要是计算左右子树是否平衡的时候，记录两个子树的高度
 * 只要任何节点的左右子树高度差值大于1，则记录表示为为false
 */
public class Offer55 {
    public static void main(String[] args) {
        Offer55 o = new Offer55();
        TreeNode treeNode = Utils.initTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.print(o.isBalanced(treeNode));
        treeNode = Utils.initTreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        Utils.print(o.isBalanced(treeNode));
    }

    boolean flag;

    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        getDepth(root, 0);
        return flag;
    }

    public int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        } else {
            int leftDepth = getDepth(root.left, depth + 1);
            int rightDepth = getDepth(root.right, depth + 1);
            // 比较两数的差值
            if (flag) {
                flag = Math.abs(leftDepth - rightDepth) <= 1;
            }
            return Math.max(leftDepth, rightDepth);
        }
    }
}
