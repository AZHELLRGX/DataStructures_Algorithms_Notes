package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;


/**
 * 687. 最长同值路径
 * 注意两个点:
 * 1、最长路径有一个要求，节点的值必须是一样的
 * 2、最长路径指的是边长，也就是节点数减一
 * <p>
 * DFS，遇到一样的节点，就继续往下检索，遇到不一样的就作为新的节点继续往下检索
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        LongestUnivaluePath l = new LongestUnivaluePath();
        TreeNode root = Utils.initTreeNode(new Integer[]{5, 4, 5, 1, 1, null, 5});
        Utils.print(l.longestUnivaluePath(root));
        root = Utils.initTreeNode(new Integer[]{1, 4, 5, 4, 4, null, 5});
        Utils.print(l.longestUnivaluePath(root));
    }

    int maxPathLen;

    public int longestUnivaluePath(TreeNode root) {
        maxPathLen = 0;
        if (root == null) {
            return maxPathLen;
        }
        dfs(root);
        return maxPathLen;
    }

    private int dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int leftPathLen = 0;
        if (node.left != null) {
            if (node.left.val == node.val) {
                leftPathLen = dfs(node.left) + 1;
            } else {
                // 该节点开始继续往下检索
                dfs(node.left);
            }
        }
        int rightPathLen = 0;
        if (node.right != null) {
            if (node.right.val == node.val) {
                rightPathLen = dfs(node.right) + 1;
            } else {
                // 该节点开始继续往下检索
                dfs(node.right);
            }
        }
        maxPathLen = Math.max(maxPathLen, leftPathLen + rightPathLen);
        return Math.max(leftPathLen, rightPathLen);
    }
}
