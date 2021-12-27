package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.*;

/**
 * 1609. 奇偶树
 * 初始思路是使用队列解题
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 */
public class EvenOddTree {
    public static void main(String[] args) {
        EvenOddTree evenOddTree = new EvenOddTree();
        Utils.print(evenOddTree.isEvenOddTree(Objects.requireNonNull(Utils.initTreeNode(new Integer[]{1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2}))));
        Utils.print(evenOddTree.isEvenOddTree(Objects.requireNonNull(Utils.initTreeNode(new Integer[]{5, 4, 2, 3, 3, 7}))));
        Utils.print(evenOddTree.isEvenOddTree(Objects.requireNonNull(Utils.initTreeNode(new Integer[]{5, 9, 1, 3, 5, 7}))));
        Utils.print(evenOddTree.isEvenOddTree(Objects.requireNonNull(Utils.initTreeNode(new Integer[]{1}))));
        Utils.print(evenOddTree.isEvenOddTree(Objects.requireNonNull(Utils.initTreeNode(new Integer[]{11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2, 17}))));
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root.val % 2 == 0) {
            return false;
        }
        Deque<NodePair> queue = new ArrayDeque<>();
        queue.addLast(new NodePair(0, root));
        // 用一个Map存储层级当前遍历到数据
        Map<Integer, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            // 队列元素依次出队
            NodePair nodePair = queue.pollFirst();
            TreeNode node = nodePair.node;
            int level = nodePair.level + 1;
            if (node.left != null) {
                if (isNodeValid(node.left, level, map.getOrDefault(level, 0))) {
                    map.put(level, node.left.val);
                    queue.addLast(new NodePair(level, node.left));
                } else {
                    return false;
                }
            }
            if (node.right != null) {
                if (isNodeValid(node.right, level, map.getOrDefault(level, 0))) {
                    map.put(level, node.right.val);
                    queue.addLast(new NodePair(level, node.right));
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isNodeValid(TreeNode node, int level, int currentValue) {
        if (level % 2 == 0 && node.val % 2 == 1 && (currentValue == 0 || node.val > currentValue))
            return true;
        else
            return level % 2 == 1 && node.val % 2 == 0 && (currentValue == 0 || node.val < currentValue);
    }

    static class NodePair {
        int level;
        TreeNode node;

        NodePair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
}
