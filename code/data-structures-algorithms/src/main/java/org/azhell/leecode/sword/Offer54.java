package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 利用二叉搜索树的性质
 * 中序遍历的结果就是有序的
 * 但是要反着来，右节点、根节点、左节点
 * 一边遍历，一遍记录最大值即可
 */
public class Offer54 {
    public static void main(String[] args) {
        Offer54 o = new Offer54();
        TreeNode node = Utils.initTreeNode(new Integer[]{3, 1, 4, null, 2});
        Utils.print(o.kthLargest(node, 1));
        node = Utils.initTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        Utils.print(o.kthLargest(node, 3));
    }

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            while (node != null) {
                deque.push(node);
                node = node.right;
            }
            if (!deque.isEmpty()) {
                node = deque.pop();
                k--;
                if (k == 0) {
                    return node.val;
                }
                node = node.left;
            }
        }
        return 0;
    }
}
