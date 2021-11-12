package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 61. 旋转链表
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode listNode = Utils.initLinkedList(new int[]{1, 2, 3, 4, 5});
        Utils.print(new RotateList().rotateRight(listNode, 2));
        listNode = Utils.initLinkedList(new int[]{0, 1, 2});
        Utils.print(new RotateList().rotateRight(listNode, 0));
        listNode = Utils.initLinkedList(new int[]{1});
        Utils.print(new RotateList().rotateRight(listNode, 0));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int nodeListLength = 1;
        ListNode node = head;
        while (node.next != null) {
            nodeListLength++;
            node = node.next;
        }

        k = nodeListLength - k % nodeListLength;
        if (k != 0 && k != nodeListLength) {
            // 先形成一个环
            node.next = head;
            // 上一个节点
            ListNode lastNode = head;
            while (k > 0) {
                lastNode = head;
                head = head.next;
                k--;
            }
            lastNode.next = null;
        }
        return head;
    }
}
