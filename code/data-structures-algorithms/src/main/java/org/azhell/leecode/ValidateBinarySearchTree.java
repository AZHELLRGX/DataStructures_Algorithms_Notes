package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 98. 验证二叉搜索树
 * 有一个取巧的办法，中序遍历后判断升序方式，但是这种方法需要将树全部遍历完，费力不讨好
 * 尝试直接利用搜索树的性质，除非节点已经为null否则就判断当前节点的所有子树是否满足
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        TreeNode treeNode = Utils.initTreeNode(new Integer[]{5, 1, 4, null, null, 3, 6});
        Utils.print(v.isValidBST(treeNode));
        Utils.initTreeNode(new Integer[]{5, 4, 6, null, null, 3, 7});
        // 测试用例看出问题，需要将父节点的值一直往下面带
        Utils.print(v.isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        // 一开始想复杂的，一直在和左右子树较劲，其实只需要判断当前节点是否满足就可以了，淦
        if (root.val < max && root.val > min) {
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        } else {
            return false;
        }
    }
}