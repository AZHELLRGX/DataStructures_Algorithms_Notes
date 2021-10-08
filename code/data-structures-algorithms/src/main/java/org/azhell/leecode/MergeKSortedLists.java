package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 首先想到的就是归并排序: 两两排序，然后总排序
 * todo 目前归并排序的效率看起来还可以，后续尝试一下其他的解法
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = Utils.initLinkedList(new int[]{1, 2, 4});
        ListNode l2 = Utils.initLinkedList(new int[]{1, 2, 6});
        ListNode l3 = Utils.initLinkedList(new int[]{1, 3, 5});
        ListNode l4 = Utils.initLinkedList(new int[]{1, 3, 4});
        Utils.printLinkedList(new MergeKSortedLists().mergeKLists(new ListNode[]{l1, l2, l3, l4}));


        l1 = Utils.initLinkedList(new int[]{1, 4, 5});
        l2 = Utils.initLinkedList(new int[]{1, 3, 4});
        l3 = Utils.initLinkedList(new int[]{2, 6});
        Utils.printLinkedList(new MergeKSortedLists().mergeKLists(new ListNode[]{l1, l2, l3}));
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));
        return mergeLists(listNodes.subList(0, listNodes.size() / 2), listNodes.subList(listNodes.size() / 2, listNodes.size()));
    }

    public ListNode mergeLists(List<ListNode> ln1, List<ListNode> ln2) {
        if (ln1.size() == 1 && ln2.size() == 1) {
            return mergeTwoLists(ln1.get(0), ln2.get(0));
        } else if (ln1.size() == 1 && ln2.isEmpty()) {
            return ln1.get(0);
        } else if (ln2.size() == 1 && ln1.isEmpty()) {
            return ln2.get(0);
        } else {
            ListNode l1 = mergeLists(ln1.subList(0, ln1.size() / 2), ln1.subList(ln1.size() / 2, ln1.size()));
            ListNode l2 = mergeLists(ln2.subList(0, ln2.size() / 2), ln2.subList(ln2.size() / 2, ln2.size()));
            return mergeTwoLists(l1, l2);
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode newLinkedList = null;
        if (l1 != null && l2 != null) {
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
        return head.next;
    }
}
