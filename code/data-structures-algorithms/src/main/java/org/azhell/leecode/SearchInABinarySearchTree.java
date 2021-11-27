package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * 要注意数据是一个二叉搜索树
 * 主要是学习一下数据结构
 */
public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        // 这里就不写测试了，二叉树初始化方法以后再补充
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
