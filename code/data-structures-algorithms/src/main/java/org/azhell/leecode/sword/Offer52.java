package org.azhell.leecode.sword;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 160. 相交链表
 * <p>
 * 本题需要注意题目的要求：
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * 这道题目在思考上还是有些难度的
 * 如果设交集链表长c,链表1除交集的长度为a，链表2除交集的长度为b，有
 * a + c + b = b + c + a  当遍历完成后，第一个出现的节点就是公共节点
 * 若无交集，则a + b = b + a 当遍历完成后，第一个共同节点为null
 */
public class Offer52 {
    public static void main(String[] args) {
        Offer52 o = new Offer52();
        ListNode c = Utils.initLinkedList(new int[]{8, 4, 5});
        ListNode headA = init(new int[]{4, 1}, c);
        ListNode headB = init(new int[]{5, 6}, c);
        Utils.print(o.getIntersectionNode(headA, headB));
    }

    private static ListNode init(int[] arr, ListNode common) {
        ListNode head = Utils.initLinkedList(arr);
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = common;
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
