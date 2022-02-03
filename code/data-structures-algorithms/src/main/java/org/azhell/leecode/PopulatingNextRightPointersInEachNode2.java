package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 题目要求只能使用常数级的额外空间
 * 广度优先搜索
 * 一开始的思路就是借助父节点的next指针，但是判断逻辑代码确实比较多
 * 可以将每层视为一个链表
 * 不得不说还是官方的题解巧妙，不用那么多的判断逻辑，代码超级简洁
 */
public class PopulatingNextRightPointersInEachNode2 {
    public static void main(String[] args) {
        Utils.print("不便测试");
    }

    // 当前层节点的前驱节点
    Node pre = null;
    // 下一层的第一个节点
    Node newStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        newStart = root;
        while (newStart != null) {
            Node curNode = newStart;
            pre = null;
            newStart = null;
            while (curNode != null) {
                if (curNode.left != null) {
                    handle(curNode.left);
                }
                if (curNode.right != null) {
                    handle(curNode.right);
                }
                curNode = curNode.next;
            }
        }
        return root;
    }

    private void handle(Node node) {
        if (pre != null) {
            pre.next = node;
        }
        if (newStart == null) {
            newStart = node;
        }
        pre = node;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    ;
}
