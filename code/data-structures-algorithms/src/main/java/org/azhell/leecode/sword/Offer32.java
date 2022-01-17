package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.*;

/**
 * 剑指 Offer 32
 * 一共三道题
 * 第二第三道题分别对应主站的102和103题，不再赘述
 */
public class Offer32 {
    public static void main(String[] args) {
        final TreeNode root = Utils.initTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        Offer32 o = new Offer32();
        Utils.print(o.levelOrder(root));
    }

    /**
     * I. 从上到下打印二叉树
     * 使用队列
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            final TreeNode treeNode = deque.pollFirst();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                deque.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.addLast(treeNode.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
