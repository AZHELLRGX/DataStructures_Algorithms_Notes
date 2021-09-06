package org.azhell.linkedlist;

/**
 * Joseph问题为:设编号为1，2, …n的n个人围坐一圈，
 * 约定编号为k (1<=k<=n)的人从1开始报数，数到m的那个人出列，
 * 它的下一位又从1开始报数，数到m的那个人又出列，依次类推，
 * 直到所有人出列为止，由此产生一个出队编号的序列。
 * <p>
 * 构造一个环形单向链表，
 * head节点是0，
 * 1、从节点k开始遍历，
 * 2、节点k + m出列，
 * 3、k+m+1成为新的头节点，k置为0，m不变，继续遍历，重复步骤2
 */
public class JosephQuestion {
    public static void main(String[] args) {
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>();
        circularLinkedList.addFirst("张三");
        circularLinkedList.addFirst("李四");
        circularLinkedList.addFirst("王五");
        circularLinkedList.addFirst("赵六");
        circularLinkedList.addFirst("钱七");
        circularLinkedList.addFirst("Jack");
        circularLinkedList.addFirst("Lucy");
        circularLinkedList.addFirst("Alice");
        circularLinkedList.addFirst("Mike");
        circularLinkedList.addFirst("Bob");
        circularLinkedList.addFirst("Albert");
        circularLinkedList.addFirst("Winston");
        System.out.println(circularLinkedList);
        int size = circularLinkedList.size();
        int k = 2;
        int m = 4;
        // Winston->Albert->Bob->Mike->Alice->Lucy->Jack->钱七->赵六->王五->李四->张三
        int index = k + m - 2;
        System.out.println("index is " + index
                + " 出列人员 is " + circularLinkedList.remove(index)
                + " 当前环 is " +circularLinkedList);
        for (int i = 1; i < size; i++) {
            index = index + (m-1);
            System.out.println("index is " + index
                    + " 出列人员 is " + circularLinkedList.remove(index)
                    + " 当前环 is " +circularLinkedList);
            // 越过一次尾节点，将索引重置
            if (index >= circularLinkedList.size()){
                index = 0;
            }
        }
    }
}
