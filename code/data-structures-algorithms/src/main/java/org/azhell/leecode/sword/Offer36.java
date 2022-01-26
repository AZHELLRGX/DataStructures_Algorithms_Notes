package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 中序遍历
 * 内存消耗是时间复杂度都挺高的
 * 注意。原题使用的是Node，但是结构其实与TreeNode对象一致
 */
public class Offer36 {
    public static void main(String[] args) {
        Offer36 o = new Offer36();
        TreeNode node = Utils.initTreeNode(new Integer[]{4, 2, 5, 1, 3});
        Utils.print(o.treeToDoublyList(node));
        node = Utils.initTreeNode(new Integer[]{1});
        Utils.print(o.treeToDoublyList(node));
        node = Utils.initTreeNode(new Integer[]{});
        Utils.print(o.treeToDoublyList(node));
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            if (!deque.isEmpty()) {
                node = deque.pop();
                list.add(node);
                node = node.right;
            }
        }
        for (int i = 1; i < list.size() - 1; i++) {
            final TreeNode cur = list.get(i);
            final TreeNode pre = list.get(i - 1);
            final TreeNode next = list.get(i + 1);
            cur.left = pre;
            cur.right = next;
        }
        // 头尾节点
        final TreeNode head = list.get(0);
        final TreeNode tail = list.get(list.size() - 1);
        head.left = tail;
        if (list.size() > 1) {
            head.right = list.get(1);
        }
        tail.right = head;
        if (list.size() > 1) {
            tail.left = list.get(list.size() - 2);
        }
        return head;
    }
}
