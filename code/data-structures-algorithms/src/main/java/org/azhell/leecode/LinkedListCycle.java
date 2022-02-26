package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 本地测试用例构造比较复杂，所以不做本地测试
 */
public class LinkedListCycle {

    // Hash表
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curNode = head;
        while (curNode != null) {
            // 利用add添加的返回值来直接判断
            if (!set.add(curNode)) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    // 快慢指针解法，类似“龟兔赛跑”，快指针每次移动两步，慢指针每次移动一步
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
