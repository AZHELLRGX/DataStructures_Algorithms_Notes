package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 155. 最小栈
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class Offer30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Utils.print(minStack.min());
        minStack.pop();
        Utils.print(minStack.top());
        Utils.print(minStack.min());
    }

    static class Node {
        // 每个节点存储当前最小值这个方案真的太妙了
        int curVal;
        int minVal;
        Node next = null;

        Node(int curVal, int minVal) {
            this.curVal = curVal;
            this.minVal = minVal;
        }
    }

    static class MinStack {

        Node head;

        public MinStack() {
            this.head = null;
        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x);
            } else {
                Node node = new Node(x, Math.min(head.minVal, x));
                node.next = head;
                head = node;
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.curVal;
        }

        public int min() {
            return head.minVal;
        }
    }

}
