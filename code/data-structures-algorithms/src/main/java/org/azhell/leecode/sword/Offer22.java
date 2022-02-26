package org.azhell.leecode.sword;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 典型的双指针题目
 * 一个指针比另外一个指针晚k次出发
 */
public class Offer22 {
    public static void main(String[] args) {
        Offer22 o = new Offer22();
        ListNode listNode = Utils.initLinkedList(new int[]{1, 2, 3, 4, 5});
        Utils.print(o.getKthFromEnd(listNode, 2));
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curNode = head;
        ListNode newHead = head;
        int i = k;
        while (curNode != null) {
            if (i == 0) {
                newHead = newHead.next;
            } else {
                i--;
            }
            curNode = curNode.next;

        }
        return newHead;
    }
}
