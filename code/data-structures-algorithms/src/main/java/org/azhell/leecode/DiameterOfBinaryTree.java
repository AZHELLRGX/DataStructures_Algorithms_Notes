package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 543. 二叉树的直径
 * 有一个错误观点，需要纠正，最大长度的路径可能不会经过二叉树的根节点！！
 * 解决方案：
 * BFS，深度优先搜索，针对每一个节点，都探查左右子树的最大深度
 * 这道题的难点在于如何在遍历的过程中就找到最大值
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        final TreeNode root = Utils.initTreeNode(new Integer[]{5, 1, 4, null, null, 3, 6});
        Utils.print(d.diameterOfBinaryTree(root));
    }

    int maxDeep = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxDeep;
    }


    private int dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int leftSize = node.left == null ? 0 : dfs(node.left) + 1;
        int rightSize = node.right == null ? 0 : dfs(node.right) + 1;
        // 遍历的过程中针对每个节点，都去判断最大直径
        maxDeep = Math.max(maxDeep, leftSize + rightSize);
        return Math.max(leftSize, rightSize);
    }
}
