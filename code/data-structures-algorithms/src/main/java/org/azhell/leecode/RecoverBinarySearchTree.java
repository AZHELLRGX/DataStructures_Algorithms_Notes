package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 题目里面说的是只有两个节点被交换了
 * 还是使用中序遍历解题，遇到非递增点，依次与前面的节点交换数值即可
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        TreeNode treeNode = Utils.initTreeNode(new Integer[]{1, 3, null, null, 2});
        r.recoverTree(treeNode);
        treeNode = Utils.initTreeNode(new Integer[]{3, 1, 4, null, null, 2});
        r.recoverTree(treeNode);
        treeNode = Utils.initTreeNode(new Integer[]{2, null, 1});
        r.recoverTree(treeNode);
        treeNode = Utils.initTreeNode(new Integer[]{2, 3, 1});
        r.recoverTree(treeNode);
    }


    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node);
                root = node.right;
                // 循环与list中的元素交换值，直到找到比它的值小的节点
                for (int i = list.size() - 2; i >= 0; i--) {
                    if (node.val < list.get(i).val) {
                        int temp = node.val;
                        node.val = list.get(i).val;
                        list.get(i).val = temp;
                        node = list.get(i);
                    } else {
                        break;
                    }
                }

            }
        }
    }

}
