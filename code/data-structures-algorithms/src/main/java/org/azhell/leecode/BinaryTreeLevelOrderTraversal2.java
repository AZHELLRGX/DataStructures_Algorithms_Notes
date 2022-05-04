package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 * 先层序遍历，算法和之前的有一些改变
 * 然后反转结果list即可
 */
public class BinaryTreeLevelOrderTraversal2 {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal2 b = new BinaryTreeLevelOrderTraversal2();
        TreeNode root = Utils.initTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.print(b.levelOrderBottom(root));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if (remove.left != null) queue.add(remove.left);
                if (remove.right != null) queue.add(remove.right);
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }


}
