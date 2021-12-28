package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树II
 * 递归
 */
public class UniqueBinarySearchTrees2 {
    public static void main(String[] args) {
        UniqueBinarySearchTrees2 u = new UniqueBinarySearchTrees2();
        Utils.print(u.generateTrees(3));
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        // 使用LinkedList减少扩容带来的性能损耗
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            // 必须填空，不然子树拼接会有问题
            result.add(null);
        }
        for (int i = start; i <= end; i++) {
            final List<TreeNode> leftTreeNodes = generateTrees(start, i - 1);
            final List<TreeNode> rightTreeNodes = generateTrees(i + 1, end);
            // 左子树，右子树，分别找一条合并
            for (TreeNode leftTreeNode : leftTreeNodes) {
                for (TreeNode rightTreeNode : rightTreeNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTreeNode;
                    treeNode.right = rightTreeNode;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}
