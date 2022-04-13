package org.azhell.leecode;


import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * 二叉树的层序遍历应用题
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView b = new BinaryTreeRightSideView();
        TreeNode node = Utils.initTreeNode(new Integer[]{1, 2, 3, null, 5, null, 4});
        Utils.print(b.rightSideView(node));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Deque<Pair> deque = new ArrayDeque<>();
        deque.addLast(new Pair(0, root));
        while (!deque.isEmpty()) {
            final Pair pair = deque.pollFirst();
            if (deque.peekFirst() == null || pair.index < deque.peekFirst().index) {
                res.add(pair.node.val);
            }
            if (pair.node.left != null)
                deque.addLast(new Pair(pair.index + 1, pair.node.left));
            if (pair.node.right != null)
                deque.addLast(new Pair(pair.index + 1, pair.node.right));
        }
        return res;
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
