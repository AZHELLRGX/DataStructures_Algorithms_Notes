package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 这一题也没有任何难度，直接在上一题的基础上完成即可
 * 如果根节点层级是0，那么奇数层就是从右往左遍历，偶数层这是从左往右遍历
 * 借助双端队列实现
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
        Utils.print(b.zigzagLevelOrder(Utils.initTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        Utils.print(b.zigzagLevelOrder(Utils.initTreeNode(new Integer[]{3, 9, 20, 10, 1, 15, 7})));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        } else {
            List<Deque<Integer>> tempList = new ArrayList<>();
            // 使用队列迭代的方式
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, root));

            while (!queue.isEmpty()) {
                final Pair pair = queue.poll();
                if (pair.index > tempList.size() - 1) {
                    tempList.add(new ArrayDeque<>());
                }
                if (pair.index % 2 == 0) {
                    // 从左往右
                    tempList.get(pair.index).addLast(pair.node.val);
                } else {
                    // 从右往左
                    tempList.get(pair.index).addFirst(pair.node.val);
                }
                addPair(pair.node.left, pair.index, queue);
                addPair(pair.node.right, pair.index, queue);
            }
            List<List<Integer>> result = new ArrayList<>(tempList.size());
            for (Deque<Integer> deque : tempList) {
                result.add(new ArrayList<>(deque));
            }
            return result;
        }
    }

    public void addPair(TreeNode node, int index, Queue<Pair> queue) {
        if (node != null) {
            queue.add(new Pair(index + 1, node));
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
