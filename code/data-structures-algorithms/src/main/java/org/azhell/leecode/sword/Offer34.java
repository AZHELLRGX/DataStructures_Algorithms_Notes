package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 113. 路径总和 II
 */
public class Offer34 {
    public static void main(String[] args) {
        Offer34 o = new Offer34();
        TreeNode node = Utils.initTreeNode(new Integer[]{1, -2, -3, 1, 3, -2, null, -1});
        Utils.print(o.pathSum(node, -1));
        node = Utils.initTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        Utils.print(o.pathSum(node, 22));
        node = Utils.initTreeNode(new Integer[]{1, 2, 3});
        Utils.print(o.pathSum(node, 5));
        node = Utils.initTreeNode(new Integer[]{1, 2});
        Utils.print(o.pathSum(node, 0));
        node = Utils.initTreeNode(new Integer[]{});
        Utils.print(o.pathSum(node, 1));

    }

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSumHelper(root, target, list, 0);
        return result;
    }

    private void pathSumHelper(TreeNode node, int target, List<Integer> list, int t) {
        if (node != null) {
            // 是叶子节点
            if (node.val + t == target && node.left == null && node.right == null) {
                list.add(node.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            } else { // 节点值可能是负数
                list.add(node.val);
                pathSumHelper(node.left, target, list, t + node.val);
                pathSumHelper(node.right, target, list, t + node.val);
                list.remove(list.size() - 1);
            }
        }
    }
}
