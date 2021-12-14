package org.azhell.tool;

import org.azhell.leecode.entry.ListNode;
import org.azhell.leecode.entry.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Utils {

    private Utils() {
        // do nothing
    }

    /**
     * 使用leet-code的一维数组初始化一棵二叉树
     * 数组是先序遍历的结果
     */
    public static TreeNode initTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null && node != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null && node != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
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
            print("[]");
        } else {
            StringBuilder s = new StringBuilder("[");
            while (head.next != null) {
                s.append(head.val).append(",");
                head = head.next;
            }
            s.append(head.val);
            s.append("]");
            print(s);
        }
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void print(ListNode listNode) {
        StringBuilder s = new StringBuilder("[");
        while (listNode != null) {
            s.append(listNode.val);
            listNode = listNode.next;
            if (listNode != null) {
                s.append(",");
            }
        }
        s.append("]");
        print(s);
    }

    public static void print(int[][] array) {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            s.append("[");
            for (int j = 0; j < array[i].length; j++) {
                s.append(array[i][j]);
                if (j != array[i].length - 1) {
                    s.append(",");
                }
            }
            if (i != array.length - 1) {
                s.append("],\n");
            }
        }
        s.append("]]");
        print(s);
    }

    public static void print(Object[] array) {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            s.append(array[i]);
            if (i != array.length - 1) {
                s.append(",");
            }
        }
        s.append("]");
        print(s);
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
        print(handleLeetcodeQuestionENName("Search Insert Position"));
    }
}
