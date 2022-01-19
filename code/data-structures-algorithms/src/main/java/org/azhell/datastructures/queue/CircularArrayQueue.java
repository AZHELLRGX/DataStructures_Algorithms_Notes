package org.azhell.datastructures.queue;


/**
 * 环形队列
 */
public class CircularArrayQueue {
    private final int[] array;
    // 队列头
    private int head;
    // 队列尾
    private int tail;
    private final int capacity;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity + 1;
        // 需要加1，环形队列需要预留一个空位
        this.array = new int[this.capacity];
        head = tail = 0;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    public void add(int element) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("队列已满");
        }
        array[tail] = element;
        tail = (tail + 1) % capacity;
    }

    public int get() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列无元素");
        } else {
            int tempEle = array[head];
            head = (head + 1) % capacity;
            return tempEle;
        }
    }

    public int head() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列无元素");
        } else {
            return array[head];
        }
    }

    public String toString() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列无元素");
        }
        StringBuilder s = new StringBuilder();
        if (head < tail) {
            for (int i = head; i <= tail-1; i++) {
                s.append(array[i]).append("\t");
            }
        }else{
            for (int i = head; i <= capacity - 1; i++) {
                s.append(array[i]).append("\t");
            }
            for (int i = 0; i <= tail-1; i++) {
                s.append(array[i]).append("\t");
            }
        }
        return s.toString();
    }
}
