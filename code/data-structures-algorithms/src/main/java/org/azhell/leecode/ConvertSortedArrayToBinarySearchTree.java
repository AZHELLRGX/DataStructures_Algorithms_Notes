package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 因为数组是有序的，所以我认为可以使用二分方法来判定左右子树，然后递归创建左右子树
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
        TreeNode treeNode = c.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        Utils.print(treeNode);
        treeNode = c.sortedArrayToBST(new int[]{1, 3});
        Utils.print(treeNode);
        treeNode = c.sortedArrayToBST(new int[]{1});
        Utils.print(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createSubNode(nums, 0, nums.length - 1);
    }

    private TreeNode createSubNode(int[] nums, int start, int end) {
        TreeNode node = null;
        if (start <= end) {
            int mid = start + (end - start) / 2;
            node = new TreeNode(nums[mid]);
            node.left = createSubNode(nums, start, mid - 1);
            node.right = createSubNode(nums, mid + 1, end);
        }
        return node;
    }
}
