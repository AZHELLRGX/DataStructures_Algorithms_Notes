package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 递归
 * 递归在对树，尤其是二叉树的处理中非常常见
 * <p>
 * 另外一种方法就是迭代法
 */
public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree s = new SymmetricTree();
        Utils.print(s.isSymmetric(Utils.initTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        Utils.print(s.isSymmetric1(Utils.initTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        Utils.print(s.isSymmetric(Utils.initTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3})));
        Utils.print(s.isSymmetric1(Utils.initTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3})));
        Utils.print(s.isSymmetric(Utils.initTreeNode(new Integer[]{1, 2, 3})));
        Utils.print(s.isSymmetric1(Utils.initTreeNode(new Integer[]{1, 2, 3})));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isEqual(root.left, root.right);
        }
    }

    // 递归方法
    public boolean isEqual(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && isEqual(p.left, q.right) && isEqual(p.right, q.left);
        }
    }

    // 迭代方法
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            final TreeNode treeNode1 = queue.poll();
            final TreeNode treeNode2 = queue.poll();
            if (treeNode1 == null && treeNode2 == null) {
                continue;
            } else if (treeNode1 == null || treeNode2 == null) {
                return false;
            } else {
                // 相邻的两个节点就是镜像对称的
                if (treeNode1.val == treeNode2.val) {
                    // 依次压入treeNode1的左子树，treeNode2的右子树，treeNode1的右子树，treeNode2的左子树
                    queue.add(treeNode1.left);
                    queue.add(treeNode2.right);
                    queue.add(treeNode1.right);
                    queue.add(treeNode2.left);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
