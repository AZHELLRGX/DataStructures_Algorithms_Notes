package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 173. 二叉搜索树迭代器
 * 设计类型题目
 * 二叉树的中序遍历
 */
public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode treeNode = Utils.initTreeNode(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator bstIterator = new BSTIterator(treeNode);
        Utils.print(bstIterator.next());
        Utils.print(bstIterator.next());
        Utils.print(bstIterator.hasNext());
        Utils.print(bstIterator.next());
        Utils.print(bstIterator.hasNext());
        Utils.print(bstIterator.next());
        Utils.print(bstIterator.hasNext());
        Utils.print(bstIterator.next());
        Utils.print(bstIterator.hasNext());
    }

    static class BSTIterator {

        Deque<TreeNode> deque;
        TreeNode node;

        public BSTIterator(TreeNode root) {
            deque = new ArrayDeque<>();
            node = root;
        }

        public int next() {
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            int val = 0;
            if (!deque.isEmpty()) {
                TreeNode pop = deque.pop();
                val = pop.val;
                node = pop.right;
            }
            return val;
        }

        public boolean hasNext() {
            return node != null || !deque.isEmpty();
        }
    }
}
