package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 还是类似上一题的迭代算法，使用队列实现
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        Utils.print(b.levelOrder(Utils.initTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        } else {
            List<List<Integer>> result = new ArrayList<>();
            // 使用队列迭代的方式
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, root));

            while (!queue.isEmpty()) {
                final Pair pair = queue.poll();
                if (pair.index > result.size() - 1) {
                    result.add(new ArrayList<>());
                }
                result.get(pair.index).add(pair.node.val);
                if (pair.node.left != null) {
                    queue.add(new Pair(pair.index + 1, pair.node.left));
                }
                if (pair.node.right != null) {
                    queue.add(new Pair(pair.index + 1, pair.node.right));
                }
            }
            return result;
        }
    }

    static class Pair {
        int index;
        TreeNode node;

        Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }
}
