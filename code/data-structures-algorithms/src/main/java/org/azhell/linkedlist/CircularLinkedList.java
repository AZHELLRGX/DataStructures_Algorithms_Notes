package org.azhell.linkedlist;

/**
 * 单向循环链表
 */
public class CircularLinkedList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> head;//保存头节点
    private Node<E> tail;//保存尾节点
    private int size = 0;

    public int size() {
        return size;
    }

    /**
     * 尾部插入新节点
     *
     * @param e new item value
     */
    public void addLast(E e) {
        if (isEmpty()) {
            head = new Node<>(e, head);
            tail = head;
        } else {
            Node<E> newNode = new Node<>(e, null);
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    /**
     * 头部插入新节点
     *
     * @param e new item value
     */
    public void addFirst(E e) {
        if (isEmpty()) {
            head = new Node<>(e, head);
            tail = head;
        } else {
            head = new Node<>(e, head);
            tail.next = head;
        }
        size++;
    }

    //获取指定位置的节点
    public Node<E> node(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(
                    "index is out of this list'position bounds,index is "
                            + index + " , size is " + size);
        Node<E> current = head;
        for (int i = 0; i < size && current.next != null; i++, current = current.next)
            if (i == index)
                return current;
        return null;
    }

    /**
     * 删除索引处的元素
     *
     * @param index remove item index
     */
    public E remove(int index) {
        int realIndex = index % size;
        Node<E> removeNode;
        if (realIndex == 0) {
            removeNode = head;
            head = head.next;
            tail.next = head;
        }
        //如果删除的是尾节点
        else if (realIndex == size - 1) {
            Node<E> prev = node(realIndex - 1);
            removeNode = tail;
            tail = prev;
            tail.next = head;
        }
        //如果删除的是中间节点
        else {
            Node<E> prev = node(realIndex - 1);
            removeNode = prev.next;
            prev.next = removeNode.next;
        }
        size--;
        return removeNode.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (isEmpty())
            return "[]";
        else {
            StringBuilder sb = new StringBuilder("[");
            sb.append(head.item).append("->");
            for (Node<E> current = head.next; current != head; current = current.next)
                sb.append(current.item).append("->");
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }
}
