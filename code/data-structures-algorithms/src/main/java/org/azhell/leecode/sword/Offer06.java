package org.azhell.leecode.sword;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 用自带的List解题显得很没脑子
 * 老实用栈
 */
public class Offer06 {
    public static void main(String[] args) {
        Offer06 o = new Offer06();
        final ListNode listNode = Utils.initLinkedList(new int[]{1, 3, 2});
        Utils.print(o.reversePrint(listNode));
    }

    public int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            deque.push(node.val);
            node = node.next;
        }
        int[] ans = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            ans[i++] = deque.pop();
        }
        return ans;
    }
}
