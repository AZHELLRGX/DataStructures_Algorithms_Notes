package org.azhell.leecode.sword;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 虽然这道题之前做过，但是之前的代码写的很麻烦，重新做一遍，力求简洁
 * <p>
 * 题目写多了以后，可以明显看到编码水平是提高的，尤其是对数据结构的处理开始得心应手了
 */
public class Offer25 {
    public static void main(String[] args) {
        Offer25 o = new Offer25();
        ListNode l1 = Utils.initLinkedList(new int[]{1, 2, 4});
        ListNode l2 = Utils.initLinkedList(new int[]{1, 3, 4});
        Utils.print(o.mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode curNode = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        if (l1 != null) {
            curNode.next = l1;
        } else if (l2 != null) {
            curNode.next = l2;
        }
        return tempHead.next;
    }
}
