package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 83. 删除排序链表中的重复元素
 * 链表的操作真特么麻烦，烦死了
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        Utils.print(r.deleteDuplicates(Utils.initLinkedList(new int[]{1, 1, 2})));
        Utils.print(r.deleteDuplicates(Utils.initLinkedList(new int[]{1, 1, 2, 3, 3, 3})));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return newHead;
    }
}
