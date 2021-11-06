package org.azhell.tool;

import org.azhell.leecode.entry.ListNode;

public class Utils {

    private Utils() {
        // do nothing
    }

    /**
     * 根据数组创建一个链表
     */
    public static ListNode initLinkedList(int[] array) {
        ListNode curNode = new ListNode(array[0]);
        ListNode head = curNode;
        for (int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            curNode.next = node;
            curNode = node;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
        } else {
            StringBuilder s = new StringBuilder("[");
            while (head.next != null) {
                s.append(head.val).append(",");
                head = head.next;
            }
            s.append(head.val);
            s.append("]");
            System.out.println(s);
        }
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void print(int[][] array) {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            s.append("[");
            for (int j = 0; j < array[i].length; j++) {
                s.append(array[i][j]);
                if (j != array.length - 1) {
                    s.append(",");
                }
            }
            if (i != array.length - 1) {
                s.append("],\n");
            }
        }
        s.append("]");
        System.out.println(s);
    }

    public static void print(int[] array) {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            s.append(array[i]);
            if (i != array.length - 1) {
                s.append(",");
            }
        }
        s.append("]");
        System.out.println(s);
    }

    public static String handleLeetcodeQuestionENName(String str) {
        // 使用空格将句子切分成单词
        String[] strArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        // 遍历取出每个单词，将首字母转换为大写
        for (String string : strArr) {
            String upperStr = string.substring(0, 1).toUpperCase() + string.substring(1);
            sb.append(upperStr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(handleLeetcodeQuestionENName("Search Insert Position"));
    }
}
