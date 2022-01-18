package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;


/**
 * 剑指 Offer 26. 树的子结构
 * 遍历树A，当发现树B的根节点的时候开始递归判断
 */
public class Offer26 {
    public static void main(String[] args) {
        Offer26 o = new Offer26();
        TreeNode a = Utils.initTreeNode(new Integer[]{3, 4, 5, 1, 2});
        TreeNode b = Utils.initTreeNode(new Integer[]{4, 1});
        Utils.print(o.isSubStructure(a, b));
        a = Utils.initTreeNode(new Integer[]{-2, 1});
        b = Utils.initTreeNode(new Integer[]{-2, 1, -2});
        Utils.print(o.isSubStructure(a, b));
    }

    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (b == null) {
            return false;
        } else {
            return isSubStructureHelper(a, b);
        }
    }

    public boolean isSubStructureHelper(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        if (isEqual(a, b)) {
            return true;
        } else {
            return isSubStructureHelper(a.left, b) || isEqual(a.right, b);
        }

    }

    private boolean isEqual(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            return isEqual(a.left, b.left) && isEqual(a.right, b.right);
        }
        return false;
    }
}
