package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 100. 相同的树
 * 这道题还是只能用递归解;快，但是占用空间高; 应该可以使用尾递归优化
 * 所谓各种中序、先序、后序遍历均不可
 */
public class SameTree {
    public static void main(String[] args) {
        SameTree s = new SameTree();
        final TreeNode treeNode = Utils.initTreeNode(new Integer[]{1, 2, 3});
        Utils.print(s.isSameTree(treeNode, treeNode));
        final TreeNode p = Utils.initTreeNode(new Integer[]{1, 1});
        final TreeNode q = Utils.initTreeNode(new Integer[]{1, null, 1});
        Utils.print(s.isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            // 依次比较节点的左子树和右子树
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
