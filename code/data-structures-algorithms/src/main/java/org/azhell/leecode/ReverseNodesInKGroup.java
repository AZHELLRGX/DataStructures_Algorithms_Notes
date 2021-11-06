package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;

/**
 * K 个一组翻转链表
 * 双指针解法
 * todo 明天再看
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

        // 需要两个临时变量，一个记录下一个节点，一个用来记录一组节点反转后的最后一个节点
        ListNode currentNode = head;
        ListNode kNode = head;
        while (j < nodeCount) {
            if (j - i == k) {
                while (i <= j) {
                    ListNode nextNode = currentNode.next;
                    ListNode next2Node = nextNode.next;
                    nextNode.next = kNode;
                    i++;
                }
            }
            j++;
        }
        return head;
    }
}
