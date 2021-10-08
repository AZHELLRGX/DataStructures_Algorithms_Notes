package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;

/**
 * K 个一组翻转链表
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        } else {
            ListNode newHead = head.next;
            ListNode lastNode = head;
            boolean flag = false;
            while (head != null && head.next != null) {

                // 上一个结尾的next记得保留
                if (flag) {
                    lastNode.next = afterNode;
                    lastNode = beforeNode;
                } else {
                    flag = true;
                }
            }
            return newHead;
        }
    }
}
