package org.azhell.leecode;

import org.azhell.leecode.entry.ListNode;
import org.azhell.tool.Utils;

import java.util.Random;

/**
 * 382. 链表随机节点
 * 标准的蓄水池算法
 * 算法思路大致如下：
 * <p>
 * 1.如果接收的数据量小于m，则依次放入蓄水池。
 * 2.当接收到第i个数据时，i >= m，在[0, i]范围内取以随机数d，
 * 若d的落在[0, m-1]范围内，则用接收到的第i个数据替换蓄水池中的第d个数据。
 * 3.重复步骤2。
 */
public class LinkedListRandomNode {
    public static void main(String[] args) {
        ListNode listNode = Utils.initLinkedList(new int[]{1, 2, 3});
        LinkedListRandomNode l = new LinkedListRandomNode(listNode);
        Utils.print(l.getRandom());
        Utils.print(l.getRandom());
        Utils.print(l.getRandom());
    }

    ListNode head;
    Random random = new Random();

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        // 对于本题来说，采样数据就是1，所以不需要数组存储
        int res = head.val;
        int i = 2;// 因为随机数右侧是开区间，需要+1，这里直接设置为2
        ListNode curNode = head.next;
        while (curNode != null) {
            int d = random.nextInt(i);
            if (d == 0) {
                res = curNode.val;
            }
            i++;
            curNode = curNode.next;
        }
        return res;
    }

}
