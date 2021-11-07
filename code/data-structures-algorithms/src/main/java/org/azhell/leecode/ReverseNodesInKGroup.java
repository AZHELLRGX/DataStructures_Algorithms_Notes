package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;

/**
 * K 个一组翻转链表
 * 主要考察设计能力
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        int j = 0;
        // 找到指针结束位置
        ListNode node = head;
        int nodeCount = 0;
        while (node.next != null) {
            nodeCount++;
            node = node.next;
        }
        // 先将链表整个反转
        // 然后从新的头到尾每隔k个改变头尾指针即可
        return head;
    }
}
