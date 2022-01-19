package org.azhell.datastructures.queue;

import org.azhell.datastructures.linkedlist.SingleLinkedList;

/**
 * 链表实现队列
 */
public class LinkedQueue<E> {
    // 链表实现的队列没有满的情况
    private final SingleLinkedList<E> singleLinkedList;

    public LinkedQueue() {
        this.singleLinkedList = new SingleLinkedList<>();
    }

    public void add(E element) {
        singleLinkedList.add(element);
    }

    public E get() {
        return singleLinkedList.removeFirst();
    }

    public String toString() {
        return singleLinkedList.toString();
    }
}
