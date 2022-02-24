package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 124. 二叉树中的最大路径和
 * DFS
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        TreeNode root = Utils.initTreeNode(new Integer[]{1, 2, 3});
        Utils.print(b.maxPathSum(root));
        root = Utils.initTreeNode(new Integer[]{-10, 9, 20, null, null, 15, 7});
        Utils.print(b.maxPathSum(root));
        root = Utils.initTreeNode(new Integer[]{1});
        Utils.print(b.maxPathSum(root));
        root = Utils.initTreeNode(new Integer[]{-3});
        Utils.print(b.maxPathSum(root));
        root = Utils.initTreeNode(new Integer[]{2, -1});
        Utils.print(b.maxPathSum(root));

    }

    int maxSum;

    public int maxPathSum(TreeNode root) {
        // 结果可能为负数
        maxSum = Integer.MIN_VALUE;
        maxSum = Math.max(dfs(root), maxSum);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 子路径和如果为负，则不应该累加，置为0即可
        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));
        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }
}
