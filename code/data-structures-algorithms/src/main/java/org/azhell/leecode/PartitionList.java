package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 86. 分隔链表
 * 使用两个虚拟节点
 */
public class PartitionList {
    public static void main(String[] args) {
        PartitionList p = new PartitionList();
        ListNode head = Utils.initLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        Utils.print(p.partition(head, 3));
        head = Utils.initLinkedList(new int[]{2, 1});
        Utils.print(p.partition(head, 2));
    }

    public ListNode partition(ListNode head, int x) {
        // 设置两个虚拟节点
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        ListNode tempNodeA = a;
        ListNode tempNodeB = b;
        while (head != null) {
            if (head.val >= x) {
                tempNodeB.next = head;
                tempNodeB = tempNodeB.next;
            } else {
                tempNodeA.next = head;
                tempNodeA = tempNodeA.next;
            }
            head = head.next;
        }
        tempNodeB.next = null;
        tempNodeA.next = b.next;
        return a.next;
    }
}
