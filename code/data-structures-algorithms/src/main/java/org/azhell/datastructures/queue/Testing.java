package org.azhell.datastructures.queue;

/**
 * 测试数组队列、环形队列、链表队列、阻塞队列
 */
public class Testing {
    public static void main(String[] args) {
        testArrayQueue();
        System.out.println("--------------------");
        testCircularArrayQueue();
        System.out.println("--------------------");
        testLinkedQueue();
    }

    private static void testLinkedQueue(){
        LinkedQueue<Integer> arrayQueue = new LinkedQueue<>();
        arrayQueue.add(1);
        arrayQueue.add(3);
        arrayQueue.add(11);
        System.out.println(arrayQueue.get());
        arrayQueue.add(6);
        System.out.println(arrayQueue.get());
        arrayQueue.add(10);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());
        arrayQueue.add(89);
        arrayQueue.add(79);
        System.out.println(arrayQueue);
    }


    private static void testCircularArrayQueue(){
        CircularArrayQueue arrayQueue = new CircularArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(3);
        arrayQueue.add(11);
        System.out.println(arrayQueue.get());
        arrayQueue.add(6);
        System.out.println(arrayQueue.get());
        arrayQueue.add(10);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.head());
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());
        arrayQueue.add(89);
        arrayQueue.add(79);
        System.out.println(arrayQueue);
    }

    private static void testArrayQueue(){
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(3);
        arrayQueue.add(11);
        System.out.println(arrayQueue.get());
        arrayQueue.add(6);
        System.out.println(arrayQueue.get());
        arrayQueue.add(10);
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.head());
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());
        arrayQueue.add(89);
        arrayQueue.add(79);
        System.out.println(arrayQueue);
    }
}
