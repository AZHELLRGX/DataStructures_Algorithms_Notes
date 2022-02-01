package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 分治算法
 */
public class Offer07 {
    public static void main(String[] args) {
        Offer07 o = new Offer07();
        Utils.print(o.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        Utils.print(o.buildTree(new int[]{-1}, new int[]{-1}));
    }

    Map<Integer, Integer> map;
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 中序遍历转为map结构方便检索
        int n = inorder.length;
        this.map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return buildTree(0, 0, inorder.length - 1);
    }

    // 递归参数：根节点在前序遍历的索引root，子树在中序遍历中的left和right
    private TreeNode buildTree(int rootIndex, int left, int right) {
        // 终止条件
        if (left > right) {
            return null;
        }
        int ele = preorder[rootIndex];
        TreeNode root = new TreeNode(ele);
        // 左边是左子树
        // 右边是右子树
        int index = map.get(ele);
        root.left = buildTree(rootIndex + 1, left, index - 1);
        root.right = buildTree(index - left + rootIndex + 1, index + 1, right);
        return root;
    }
}
