package org.azhell.leecode.sword;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 这一题好像和双指针没什么关系；硬要说有关系，那就是增加了一个存储前置节点的指针吧
 */
public class Offer18 {
    public static void main(String[] args) {
        Offer18 o = new Offer18();
        ListNode listNode = Utils.initLinkedList(new int[]{4, 5, 1, 9});
        Utils.print(o.deleteNode(listNode, 5));
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode curNode = head.next;
        ListNode previousNode = head;
        while (curNode != null) {
            if (curNode.val == val) {
                previousNode.next = curNode.next;
                break;
            }
            previousNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }
}
