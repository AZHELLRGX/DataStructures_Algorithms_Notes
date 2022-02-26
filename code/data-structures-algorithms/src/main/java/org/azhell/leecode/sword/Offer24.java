package org.azhell.leecode.sword;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 24. 反转链表
 * 206. 反转链表
 * 还是借助栈来解决
 * 除了栈之外，还可以使用迭代法和尾递归
 */
public class Offer24 {
    public static void main(String[] args) {
        Offer24 o = new Offer24();
        ListNode head = Utils.initLinkedList(new int[]{1, 2, 3, 4, 5});
        Utils.print(o.reverseList(head));
        head = Utils.initLinkedList(new int[]{1, 2, 3, 4, 5});
        Utils.print(o.reverseList1(head));
        head = Utils.initLinkedList(new int[]{1, 2, 3, 4, 5});
        Utils.print(o.reverseList2(head));
        head = Utils.initLinkedList(new int[]{1});
        Utils.print(o.reverseList(head));
        head = Utils.initLinkedList(new int[]{1});
        Utils.print(o.reverseList1(head));
    }

    // 使用迭代解题【效率直接100%】
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null) {
            ListNode tempNode = curNode;
            curNode = curNode.next;
            tempNode.next = preNode;
            preNode = tempNode;
        }
        return preNode;
    }

    // 尾递归解法；这个递归解法思路比较巧妙
    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode tempNode = cur.next;
        cur.next = pre;
        // 直接往后递推
        return reverse(tempNode, cur);
    }


    // 栈的效率较低
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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
