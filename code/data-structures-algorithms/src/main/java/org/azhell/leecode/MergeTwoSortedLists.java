package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 合并两个有序链表
 * 好像就是一次遍历的事情
 * todo 快速排序的思想其实是使用递归解法，后续研究
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = Utils.initLinkedList(new int[]{1, 2, 4});
        ListNode l2 = Utils.initLinkedList(new int[]{1, 3, 4});
        Utils.printLinkedList(new MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode newLinkedList = null;
        if (l1 != null && l2 != null) {
            // 其实这里可以使用哑节点代替，最后返回该节点的next即可
            if (l1.val <= l2.val) {
                head = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head = new ListNode(l2.val);
                l2 = l2.next;
            }
            newLinkedList = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    newLinkedList.next = new ListNode(l1.val);
                    newLinkedList = newLinkedList.next;
                    l1 = l1.next;
                } else {
                    newLinkedList.next = new ListNode(l2.val);
                    newLinkedList = newLinkedList.next;
                    l2 = l2.next;
                }
            }
        }
        if (l1 != null) {
            if (newLinkedList == null) {
                return l1;
            }
            newLinkedList.next = l1;
        }
        if (l2 != null) {
            if (newLinkedList == null) {
                return l2;
            }
            newLinkedList.next = l2;
        }
        return head;
    }
}
