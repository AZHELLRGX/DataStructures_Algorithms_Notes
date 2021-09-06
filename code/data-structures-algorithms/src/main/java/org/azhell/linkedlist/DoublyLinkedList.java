package org.azhell.linkedlist;


/**
 * 双向链表
 * 1、添加节点包含头加法和尾加法
 * 不管是头部还是尾部添加，当只有一个元素的时候，这个元素既是头节点也是尾节点，
 * 这是为了应对addFirst与addLast交叉使用
 */
public class DoublyLinkedList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;


    /**
     * 从头部添加新元素
     *
     * @param e new Item
     */
    public void addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f); // 设置此节点的next为当前头节点
        first = newNode; // 将新的节点置为头节点
        if (f == null) {
            last = newNode; // 如果头节点是空的话，那么尾节点一定也是空
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 从尾部添加新元素
     *
     * @param e new Item
     */
    public void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 从头部删除元素
     *
     * @return 返回删除元素的值
     */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            E tmp = first.item;
            first = last = null;
            size--;
            return tmp;
        } else {
            Node<E> f = first;
            first = f.next;
            first.prev = null;
            size--;
            return f.item;
        }
    }

    /**
     * 从尾部删除元素
     *
     * @return 返回删除元素的值
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            E tmp = last.item;
            last = first = null;
            size--;
            return tmp;
        } else {
            Node<E> l = last;
            last = l.prev;
            last.next = null;
            size--;
            return l.item;
        }
    }

    /**
     * 在指定位置插入元素 进入此方法时，index > 0 && index < size
     *
     * @param e     new item value
     * @param index new item position
     */
    private void addBefore(E e, int index) {
        Node<E> after = first.next; // 指定index后面的一个node
        for (int i = 1; i < size; i++) {
            if (i == index) {
                Node<E> newNode = new Node<>(after.prev, e, after);
                after.prev.next = newNode;
                after.prev = newNode;
            } else {
                after = after.next;
            }
        }
        size++;
    }

    /**
     * 在指定位置插入元素 进入此方法时，index > 0 && index < size - 1
     *
     * @param index delete element index
     */
    private E remove(int index) {
        Node<E> removeNode = first.next; // 指定index后面的一个node
        for (int i = 1; i < size - 1; i++) {
            if (i == index) {
                removeNode.prev.next = removeNode.next;
                removeNode.next.prev = removeNode.prev;
                break;
            } else {
                removeNode = removeNode.next;
            }
        }
        size++;
        return removeNode.item;
    }


    /**
     * 更新指定位置的元素
     *
     * @param e     new item value
     * @param index new item position
     */
    public void update(E e, int index) {
        checkElementIndex(index);
        Node<E> tmp = first; // 指定index后面的一个node
        for (int i = 0; i < size; i++) {
            if (i == index) {
                tmp.item = e;
            } else {
                tmp = tmp.next;
            }
        }
    }

    /**
     * 在指定位置插入元素
     *
     * @param index new item position
     */
    public void delete(int index) {
        checkElementIndex(index);
        if (index == size - 1) {
            removeLast();
        } else if (index == 0) {
            removeFirst();
        } else {
            remove(index);
        }
    }

    /**
     * 在指定位置插入元素
     *
     * @param e     new item value
     * @param index new item position
     */
    public void insert(E e, int index) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(e);
        } else if (index == 0) {
            addFirst(e);
        } else {
            addBefore(e, index);
        }
    }

    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException(
                    "index is out of this list'position bounds,index is "
                            + index + " , size is " + size);
        }
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException(
                    "index is out of this list'element bounds,index is "
                            + index + " , size is " + size);
        }
    }

    public int getSize() {
        return size;
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("正序打印：");
            Node<E> temp = first;
            stringBuilder.append(temp.item);
            while (temp.next != null) {
                temp = temp.next;
                stringBuilder.append(" ").append(temp.item);
            }
            stringBuilder.append("\t");
            stringBuilder.append("逆序打印：");
            temp = last;
            stringBuilder.append(temp.item);
            while (temp.prev != null) {
                temp = temp.prev;
                stringBuilder.append(" ").append(temp.item);
            }
            return stringBuilder.toString();
        }
    }

    private static class Node<E> {
        E item;
        Node<E> prev; // 前驱指针
        Node<E> next; // 后驱指针

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
