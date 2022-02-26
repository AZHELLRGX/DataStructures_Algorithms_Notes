package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        final ListNode l1 = Utils.initLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9});
        final ListNode l2 = Utils.initLinkedList(new int[]{9, 9, 9, 9});
        Utils.print(a.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null);
        ListNode curNode = head;
        boolean carry = false;
        while (l1 != null || l2 != null || carry) {
            int num = 0;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            if (carry) {
                num += 1;
            }
            if (num >= 10) {
                carry = true;
                num %= 10;
            } else {
                carry = false;
            }
            ListNode node = new ListNode(num, null);
            curNode.next = node;
            curNode = node;
        }
        return head.next;
    }
}
