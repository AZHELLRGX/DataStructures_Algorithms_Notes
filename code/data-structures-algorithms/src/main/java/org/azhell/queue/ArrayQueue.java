package org.azhell.queue;

/**
 * 数组实现队列
 */
public class ArrayQueue {
    private int[] array;
    // 队列头
    private int head;
    // 队列尾
    private int tail;

    public ArrayQueue(int capacity) {
        this.array = new int[capacity];
        // 这里的策略是head指向头部的前一个位置，tail则指向最后一个元素
        head = tail = -1;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return tail == array.length - 1;
    }

    public void add(int element) {
        if (isFull()) {
            if (head == -1) {
                throw new IndexOutOfBoundsException("队列已满");
            } else {
                // 数据搬迁
                shiftQueue();
            }
        }
        tail++;
        array[tail] = element;

    }

    private void shiftQueue() {
        int[] newArray = new int[array.length];
        int index = -1;
        for (int i = head + 1; i <= tail; i++) {
            index++;
            newArray[index] = array[i];
        }
        this.array = newArray;
        this.head = -1;
        this.tail = index;
    }

    public int get() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列无元素");
        } else {
            head++;
            return array[head];
        }
    }

    public int head() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列无元素");
        } else {
            return array[head + 1];
        }
    }

    public String toString() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列无元素");
        }
        StringBuilder s = new StringBuilder();
        for (int i = head + 1; i <= tail; i++) {
            s.append(array[i]).append("\t");
        }
        return s.toString();
    }
}
