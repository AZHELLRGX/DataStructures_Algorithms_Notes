package org.azhell.leecode;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 * 遍历+hashset
 */
public class TwoSum4 {
    public static void main(String[] args) {
        TwoSum4 t = new TwoSum4();
        Utils.print(t.findTarget(Utils.initTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7}), 9));
        Utils.print(t.findTarget(Utils.initTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7}), 28));
    }

    Set<Integer> set;

    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return traverse(root, k);
    }

    private boolean traverse(TreeNode curNode, int k) {
        if (curNode == null) {
            return false;
        }
        if (set.contains(k - curNode.val)) {
            return true;
        } else {
            set.add(curNode.val);
            if (traverse(curNode.left, k))
                return true;
            return traverse(curNode.right, k);
        }
    }
}
