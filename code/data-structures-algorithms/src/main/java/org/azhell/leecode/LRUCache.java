package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 哈希 + 双向链表
 * 调用get方法的时候需要刷新数据为
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        Utils.print(lruCache.get(1));
        lruCache.put(3, 3);
        Utils.print(lruCache.get(2));
        lruCache.put(4, 4);
        Utils.print(lruCache.get(1));
        Utils.print(lruCache.get(3));
        Utils.print(lruCache.get(4));
        Utils.print("-------------");
        lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        Utils.print(lruCache.get(1));
        Utils.print(lruCache.get(2));
    }


    static class DoublyLinkedNode {
        int key;
        int value;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;

        public DoublyLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DoublyLinkedNode() {
            // 伪节点
        }
    }

    int capacity;
    Map<Integer, DoublyLinkedNode> map;
    // java的LinkedList就是双向队列
    DoublyLinkedNode head;
    DoublyLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        // 使用伪节点作为头尾节点
        this.head = new DoublyLinkedNode();
        this.tail = new DoublyLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 将被访问的节点移动到链表尾部
        final DoublyLinkedNode node = map.get(key);
        cutChain(node);
        moveNodeToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 只修改节点的value即可
            DoublyLinkedNode node = map.get(key);
            node.value = value;
            cutChain(node);
            moveNodeToTail(node);
            return;
        }
        if (map.size() == capacity) {
            // 移除过期数据
            map.remove(head.next.key);
            cutChain(head.next);
        }
        // 新增节点
        DoublyLinkedNode node = new DoublyLinkedNode(key, value);
        map.put(key, node);
        moveNodeToTail(node);
    }

    private void cutChain(DoublyLinkedNode node) {
        final DoublyLinkedNode prev = node.prev;
        final DoublyLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveNodeToTail(DoublyLinkedNode node) {
        final DoublyLinkedNode tailPrev = tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }
}
