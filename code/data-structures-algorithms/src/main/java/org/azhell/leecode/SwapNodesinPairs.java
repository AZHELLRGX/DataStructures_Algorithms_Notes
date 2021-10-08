package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 两两交换链表中的节点
 */
public class SwapNodesinPairs {
    public static void main(String[] args) {
        Utils.printLinkedList(
                new SwapNodesinPairs().swapPairs(Utils.initLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7})
                ));
        Utils.printLinkedList(
                new SwapNodesinPairs().swapPairs(Utils.initLinkedList(new int[]{1, 2, 3, 4})
                ));
        Utils.printLinkedList(
                new SwapNodesinPairs().swapPairs(Utils.initLinkedList(new int[]{1, 2})
                ));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode newHead = head.next;
            ListNode lastNode = head;
            boolean flag = false;
            while (head != null && head.next != null) {
                ListNode beforeNode = head;
                ListNode afterNode = head.next;
                head = afterNode.next;
                beforeNode.next = head;
                afterNode.next = beforeNode;
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
