package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;

/**
 * 142. 环形链表 II
 * 想要达到O(1)的时间复杂度，可以使用快慢指针
 * fast pointer 每次两步
 * slow pointer 每次一步
 * 跑操原理
 * 难点在于如何通过快慢指针的相遇点推导出来入环点
 * 需要列方程理解，此处给出结论：
 * 当发现 slow 与fast 相遇时，我们再额外使用一个指针ptr。
 * 起始，它指向链表头部；随后，它和slow 每次向后移动一个位置。最终，它们会在入环点相遇
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else{
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
