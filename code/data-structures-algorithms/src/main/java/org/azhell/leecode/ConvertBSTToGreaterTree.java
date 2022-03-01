package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 538. 把二叉搜索树转换为累加树
 * 本题可以算作一种特殊的中序遍历，不过先遍历右节点
 */
public class ConvertBSTToGreaterTree {
    public static void main(String[] args) {
        ConvertBSTToGreaterTree c = new ConvertBSTToGreaterTree();
        final TreeNode root = Utils.initTreeNode(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        Utils.print(c.convertBST(root));
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curNode = root;
        int preNum = 0;
        while (curNode != null || !deque.isEmpty()) {
            while (curNode != null) {
                deque.addLast(curNode);
                curNode = curNode.right;
            }
            if (!deque.isEmpty()) {
                final TreeNode pop = deque.pollLast();
                pop.val += preNum;
                preNum = pop.val;
                curNode = pop.left;
            }
        }
        return root;
    }
}
