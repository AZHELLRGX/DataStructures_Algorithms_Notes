package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 144. 二叉树的前序遍历
 * 145. 二叉树的后序遍历
 * 所谓前序遍历、中序遍历、后序遍历里面的顺序都是针对的根节点的遍历顺序
 * 利用栈【主要是为了规避递归】
 */
public class BinaryTreeTraversal {
    public static void main(String[] args) {
        BinaryTreeTraversal b = new BinaryTreeTraversal();
        TreeNode treeNode = Utils.initTreeNode(new Integer[]{1, null, 2, 3});
        Utils.print(b.inorderTraversal(treeNode));
        Utils.print(b.preorderTraversal(treeNode));
        treeNode = Utils.initTreeNode(new Integer[]{});
        Utils.print(b.inorderTraversal(treeNode));
        Utils.print(b.preorderTraversal(treeNode));
        treeNode = Utils.initTreeNode(new Integer[]{1});
        Utils.print(b.inorderTraversal(treeNode));
        Utils.print(b.preorderTraversal(treeNode));
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
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

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // 后续遍历 todo 后续遍历比较难 看不太懂，迭代里面比较复杂的思路，后续再看
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 先将节点弹出来
            root = stack.pop();
            // 判断是否有右节点
            if (root.right == null || root.right == prev) {
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }
}
