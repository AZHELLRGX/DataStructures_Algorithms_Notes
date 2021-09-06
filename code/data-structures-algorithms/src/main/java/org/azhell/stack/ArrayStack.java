package org.azhell.stack;


import java.util.ArrayList;

/**
 * 数组实现的栈
 */
public class ArrayStack<E> {

    private final int capacity; // 栈容量
    private int top;  // 栈顶
    // java不允许创建泛型数组，所以这里使用基于数组的线性表代替
    private final ArrayList<E> stackList;

    public ArrayStack(int maxSize) {
        this.stackList = new ArrayList<>(maxSize);
        this.top = -1; // 栈顶默认是-1
        this.capacity = maxSize;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(E e) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("stack is full , capacity is " + capacity);
        }
        stackList.add(e);
        top++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("stack is empty , can`t pop any element");
        }
        E e = stackList.remove(top);
        top--;
        return e;
    }
}
