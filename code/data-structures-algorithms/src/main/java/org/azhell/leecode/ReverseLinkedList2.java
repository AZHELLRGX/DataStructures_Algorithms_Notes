package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 92. 反转链表 II
 * 还是借助一个虚拟节点
 * leftNode、rightNode都需要记录
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ReverseLinkedList2 r = new ReverseLinkedList2();
        ListNode head = Utils.initLinkedList(new int[]{1, 2, 3, 4, 5});
        Utils.print(r.reverseBetween(head, 2, 4));
        head = Utils.initLinkedList(new int[]{5, 4, 3, 2, 1, 0});
        Utils.print(r.reverseBetween(head, 1, 6));
        head = Utils.initLinkedList(new int[]{1, 2, 3, 4, 5});
        Utils.print(r.reverseBetween(head, 3, 4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode virtualNode = null;
        ListNode startNode = null;
        ListNode tempNode = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        while (tempNode != null) {
            if (i == left - 1) {
                leftNode = tempNode;
                tempNode = tempNode.next;
            } else if (i == right + 1) {
                rightNode = tempNode;
                break;
            } else if (i >= left && i <= right) {
                if (i == left) {
                    startNode = tempNode;
                }
                // 开始反转
                final ListNode next = tempNode.next;
                tempNode.next = virtualNode;
                virtualNode = tempNode;
                tempNode = next;

            }else{
                tempNode = tempNode.next;
            }
            i++;
        }
        if (leftNode != null) {
            leftNode.next = virtualNode;
        } else {
            head = virtualNode;
        }
        if (startNode != null)
            startNode.next = rightNode;
        return head;
    }
}
