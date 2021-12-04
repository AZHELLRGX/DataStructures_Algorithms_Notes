package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 82. 删除排序链表中的重复元素 II
 * 链表的题目写起来是真的烦啊
 * 需要多理解几遍
 */
public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 r = new RemoveDuplicatesFromSortedList2();
        Utils.print(r.deleteDuplicates(Utils.initLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5})));
        Utils.print(r.deleteDuplicates(Utils.initLinkedList(new int[]{1, 1, 1, 2, 3})));
        Utils.print(r.deleteDuplicates(Utils.initLinkedList(new int[]{1, 2, 2})));
        Utils.print(r.deleteDuplicates(Utils.initLinkedList(new int[]{1, 2, 3, 3})));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0, head);
        ListNode curNode = newHead;
        while (curNode.next != null && curNode.next.next != null) {
            if (curNode.next.val == curNode.next.next.val) {
                int repeatNum = curNode.next.val;
                // 循环删除后面相同重复元素的节点
                while (curNode.next != null && repeatNum == curNode.next.val) {
                    // 跳过重复节点就表示删除该节点
                    curNode.next = curNode.next.next;
                }
            } else {
                curNode = curNode.next;
            }
        }

        return newHead.next;
    }
}
