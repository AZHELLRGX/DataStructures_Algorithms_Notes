package org.azhell.linkedlist;

import java.util.Stack;

/**
 * 单链表
 */
public class SingleLinkedList<E> {
    private int size;
    private Node<E> head;

    public int getSize() {
        return size;
    }

    /**
     * 链表尾部添加元素
     *
     * @param e
     */
    public void add(E e) {
        if (head == null) {
            head = new Node<>(e);
            size = 1;
        } else {
            Node<E> temp = head;
            // 遍历到链表的尾部
            while (true) {
                if (temp.next == null) {
                    break;
                } else {
                    temp = temp.next;
                }
            }
            temp.next = new Node<>(e);
            size++;
        }
    }

    /**
     * 链表的逆序打印（不能改变链表的数据次序）
     * 巧妙借用栈这种数据结构
     */
    public void reversePrint() {
        if (head == null) {
            throw new NullPointerException("current singleLinkedList is null , can‘t print!");
        } else {
            Stack<E> stack = new Stack<>();
            Node<E> temp = head;
            while (temp != null) {
                stack.push(temp.item);
                temp = temp.next;
            }
            while (stack.size() > 0) {
                System.out.println(stack.pop());
            }
        }
    }

    /**
     * 反转单链表
     */
    public void reverse() {
        // 从头结点开始遍历，每扫描到一个元素就将元素指向当前头结点
        if (head == null) {
            throw new NullPointerException("current singleLinkedList is null , no need reverse!");
        } else {
            Node<E> initiallyHead = head; // 记录初始头结点，后续需要将（未来的尾节点）next置为空
            Node<E> tempNext = head.next;
            while (tempNext != null) {
                // 先保留当前节点的next
                Node<E> tmp = tempNext.next;
                tempNext.next = head;
                head = tempNext;
                tempNext = tmp;
            }
            initiallyHead.next = null;
        }

    }

    /**
     * 移出链表的第一个元素
     *
     * @return
     */
    public E removeFirst() {
        E firstItem;
        if (head == null) {
            throw new NullPointerException("current singleLinkedList is null , can't remove any element!");
        } else if (head.next == null) {
            firstItem = head.item;
            head = null;
            size--;
        } else {
            firstItem = head.item;
            head = head.next;
            size--;
        }
        return firstItem;
    }

    /**
     * 移出链表的最后一个节点
     *
     * @return
     */
    public E removeLast() {
        E lastItem;
        if (head == null) {
            throw new NullPointerException("current singleLinkedList is null , can't remove any element!");
        } else if (head.next == null) {
            lastItem = head.item;
            head = null;
            size--;
        } else {
            // 记录链表的最后一个节点
            Node<E> temp = head.next;
            // 最后一个节点的上一个节点
            Node<E> lastBefore = head;
            // 遍历到链表的尾部
            while (true) {
                if (temp.next == null) {
                    break;
                } else {
                    lastBefore = temp;
                    temp = temp.next;
                }
            }
            lastBefore.next = null;
            lastItem = temp.item;
            size--;
        }
        return lastItem;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }

    private static class Node<E> {
        // 存放元素
        E item;
        Node<E> next;

        public Node(E e) {
            this.item = e;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }
}



