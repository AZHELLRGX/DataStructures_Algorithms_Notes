package org.azhell.leecode.sword;

import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 138. 复制带随机指针的链表
 * 解法1：使用Map辅助复制
 * 解法2：直接原地修改
 */
public class Offer35 {
    public static void main(String[] args) {
        Offer35 o = new Offer35();
        final Node node = o.initTestSample(new Integer[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}});
        Utils.print(node);
        Utils.print(o.copyRandomList(node));
        Utils.print(o.copyRandomList1(node));
    }

    private Node initTestSample(Integer[][] sample) {
        // 测试用例是[value,randomNodeIndex]
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        int len = sample.length;
        Node[] nodeArray = new Node[len];
        for (int i = 0; i < len; i++) {
            nodeArray[i] = new Node(sample[i][0]);
        }
        Node head = new Node(0);
        Node curNode = head;
        for (int i = 0; i < len; i++) {
            final Node node = nodeArray[i];
            Integer index = sample[i][1];
            if (index != null) {
                node.random = nodeArray[index];
            } else {
                node.random = null;
            }
            curNode.next = node;
            curNode = curNode.next;
        }
        return head.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 原地处理【空间复杂度O(1)】
    public Node copyRandomList(Node head) {
        // 直接在原链表上进行复制，复制节点放在原节点的后面
        Node curNode = head;
        while (curNode != null) {
            Node newNode = new Node(curNode.val);
            newNode.next = curNode.next;
            // 新的节点接在原节点后面
            curNode.next = newNode;
            curNode = newNode.next;
        }
        curNode = head;
        // 因为随机指针指向的节点也已经放在原节点的后面，所以可以根据原节点的指针来处理
        while (curNode != null) {
            // 原节点后面就是新节点
            final Node newNode = curNode.next;
            // 新节点都在原节点的后面
            if (curNode.random != null)
                newNode.random = curNode.random.next;
            else {
                newNode.random = null;
            }
            // 原节点的后两位还是原节点
            curNode = curNode.next.next;
        }
        // 分离链表 注意需要将原链表的next改回来
        Node newHead = new Node(0);
        curNode = head;
        Node newCurNode = newHead;
        while (curNode != null) {
            newCurNode.next = curNode.next;
            newCurNode = newCurNode.next;
            curNode.next = curNode.next.next;
            curNode = curNode.next;
        }
        return newHead.next;
    }

    // 效率100% 其实也还ok，但是空间占用较大【空间复杂度O(n)】
    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curNode = head;
        while (curNode != null) {
            map.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }
        Node newHead = new Node(0);
        Node newCurNode = newHead;
        curNode = head;
        while (curNode != null) {
            Node tempNode = map.get(curNode);
            tempNode.next = curNode.next == null ? null : map.get(curNode.next);
            tempNode.random = curNode.random == null ? null : map.get(curNode.random);
            newCurNode.next = tempNode;
            newCurNode = newCurNode.next;
            curNode = curNode.next;
        }
        return newHead.next;
    }
}
