package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除链表的倒数第 N 个结点
 * 1、我自己的解题思路是使用额外的存储空间，无论是ArrayList还是HashMap
 * 2、比较官方的解法是使用快慢指针，快指针比慢指针先走n步，当快指针遍历完成的时候，慢指针就是需要删除的节点
 * todo 解法二后续有时间可以试试，是个很好的算法思路
 */

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Utils.printLinkedList(new RemoveNthNodeFromEndOfList().removeNthFromEnd(Utils.initLinkedList(new int[]{1, 2, 3, 4, 5}), 2));
        Utils.printLinkedList(new RemoveNthNodeFromEndOfList().removeNthFromEnd(Utils.initLinkedList(new int[]{1}), 1));
        Utils.printLinkedList(new RemoveNthNodeFromEndOfList().removeNthFromEnd(Utils.initLinkedList(new int[]{1, 2}), 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode tempNode = head;
        while (tempNode.next != null) {
            list.add(tempNode);
            tempNode = tempNode.next;
        }
        list.add(tempNode);
        int realN = list.size() - n;
        if (realN == 0) {
            if (list.size() > 1) {
                head = list.get(1);
            } else {
                head = null;
            }
        } else if (realN == list.size() - 1) {
            list.get(realN - 1).next = null;
        } else {
            list.get(realN - 1).next = list.get(realN + 1);
        }
        return head;
    }
}
