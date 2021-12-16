package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 所谓前序遍历、中序遍历、后序遍历里面的顺序都是针对的根节点
 * 利用栈【主要是为了规避递归】
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
        TreeNode treeNode = Utils.initTreeNode(new Integer[]{1, null, 2, 3});
        Utils.print(b.inorderTraversal(treeNode));
        treeNode = Utils.initTreeNode(new Integer[]{});
        Utils.print(b.inorderTraversal(treeNode));
        treeNode = Utils.initTreeNode(new Integer[]{1});
        Utils.print(b.inorderTraversal(treeNode));
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 总是不断遍历左子树
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
