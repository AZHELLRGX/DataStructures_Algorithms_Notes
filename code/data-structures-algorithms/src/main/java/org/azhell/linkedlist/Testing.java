package org.azhell.linkedlist;


/**
 * 链表专题的代码测试
 */
public class Testing {
    public static void main(String[] args) {
        // testSingleLinkedList();
        testDoublyLinkedList();
    }

    public static void testDoublyLinkedList() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        // System.out.println(doublyLinkedList);
        doublyLinkedList.addFirst(1);
        //System.out.println(doublyLinkedList);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.addFirst(5);
        doublyLinkedList.addLast(6);
        System.out.println(doublyLinkedList);

        doublyLinkedList.insert(10, 6);
        System.out.println(doublyLinkedList);
        doublyLinkedList.insert(20, 0);
        System.out.println(doublyLinkedList);
        doublyLinkedList.insert(30, 3);
        System.out.println(doublyLinkedList);

        doublyLinkedList.update(44, 8);
        System.out.println(doublyLinkedList);
        doublyLinkedList.update(55, 2);
        System.out.println(doublyLinkedList);
        doublyLinkedList.update(66, 6);
        System.out.println(doublyLinkedList);
        doublyLinkedList.update(77, 0);
        System.out.println(doublyLinkedList);

        int size = doublyLinkedList.getSize();
        for (int i = 0; i < size+1; i++) {
            System.out.println(doublyLinkedList.removeFirst() + ";" + doublyLinkedList);
        }

        doublyLinkedList.addFirst(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.addFirst(5);
        doublyLinkedList.addLast(6);
        System.out.println(doublyLinkedList);

        size = doublyLinkedList.getSize();
        for (int i = 0; i < size+1; i++) {
            System.out.println(doublyLinkedList.removeLast() + ";" + doublyLinkedList);
        }

        doublyLinkedList.addFirst(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.addFirst(5);
        doublyLinkedList.addLast(6);
        System.out.println(doublyLinkedList);

        doublyLinkedList.delete(3);
        doublyLinkedList.delete(1);
        doublyLinkedList.delete(0);
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.getSize());
    }

    public static void testSingleLinkedList() {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add("test001");
        singleLinkedList.add("test002");
        singleLinkedList.add("test003");
        System.out.println(singleLinkedList);
        System.out.println(singleLinkedList.getSize());
        singleLinkedList.reversePrint();

        // 测试removeLast方法
//        System.out.println(singleLinkedList.removeLast());
//        System.out.println(singleLinkedList);
//        System.out.println(singleLinkedList.removeLast());
//        System.out.println(singleLinkedList);
//        System.out.println(singleLinkedList.removeLast());
//        System.out.println(singleLinkedList);
//        System.out.println(singleLinkedList.removeLast());

        // 测试removeFirst方法
//        System.out.println(singleLinkedList.removeFirst());
//        System.out.println(singleLinkedList);
//        System.out.println(singleLinkedList.removeFirst());
//        System.out.println(singleLinkedList);
//        System.out.println(singleLinkedList.removeFirst());
//        System.out.println(singleLinkedList);
//        System.out.println(singleLinkedList.removeFirst());

        singleLinkedList.reverse();
        System.out.println(singleLinkedList);
        singleLinkedList.reversePrint();
    }
}
