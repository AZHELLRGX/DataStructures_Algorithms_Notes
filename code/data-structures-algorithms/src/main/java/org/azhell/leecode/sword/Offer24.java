package org.azhell.leecode.sword;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 24. 反转链表
 * 206. 反转链表
 * 还是借助栈来解决
 */
public class Offer24 {
    public static void main(String[] args) {
        Offer24 o = new Offer24();
        final ListNode head = Utils.initLinkedList(new int[]{1, 2, 3, 4, 5});
        Utils.print(o.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = new ListNode();
        ListNode curNode = newHead;
        while (!stack.isEmpty()) {
            curNode.next = stack.pop();
            curNode = curNode.next;
        }
        curNode.next = null;
        return newHead.next;
    }
}
