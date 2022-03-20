package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 114. 二叉树展开为链表
 * 二叉树的前序遍历，不借助栈，递归实现，让空间复杂度满足O(1)
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
        TreeNode root = Utils.initTreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6});
        f.flatten(root);
        Utils.print(root);
    }

    public void flatten(TreeNode root) {
        // 整个过程就是不断的遍历右子树，遇到左子树就要特殊处理
        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.left != null) {
                TreeNode next = curNode.left;
                TreeNode preNode = next;
                while (preNode.right != null) {
                    preNode = preNode.right;
                }
                // 左子树的最右侧一个节点是右子树的父节点
                preNode.right = curNode.right;
                curNode.left = null;
                // 左子树按照相同的方式展开
                curNode.right = next;
            }
            curNode = curNode.right;
        }
    }

}
