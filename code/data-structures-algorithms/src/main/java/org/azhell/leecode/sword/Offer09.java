package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class Offer09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        Utils.print(cQueue.deleteHead());
        cQueue.appendTail(3);
        Utils.print(cQueue.deleteHead());
        Utils.print(cQueue.deleteHead());
        cQueue.appendTail(4);
        cQueue.appendTail(5);
        cQueue.appendTail(6);
        cQueue.appendTail(7);
        Utils.print(cQueue.deleteHead());
        cQueue.appendTail(8);
        Utils.print(cQueue.deleteHead());
        Utils.print(cQueue.deleteHead());
        Utils.print(cQueue.deleteHead());
    }

    static class CQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public CQueue() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            if (s2.isEmpty()) {
                return -1;
            }
            return s2.pop();
        }
    }
}
