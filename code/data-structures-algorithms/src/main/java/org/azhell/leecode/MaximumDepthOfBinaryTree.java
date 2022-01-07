package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 104. 二叉树的最大深度
 * 虽然递归感觉更快，但是想继续使用队列
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        Utils.print(m.maxDepth(Utils.initTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public int maxDepth(TreeNode root) {
        // 递归，传入当前节点以及节点层级
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode node, int index) {
        if (node == null) {
            return index;
        } else {
            index += 1;
            return Math.max(maxDepth(node.left, index), maxDepth(node.right, index));
        }
    }
}
