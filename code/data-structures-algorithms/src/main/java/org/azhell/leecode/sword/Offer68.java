package org.azhell.leecode.sword;

import org.azhell.leecode.entry.TreeNode;
import org.azhell.tool.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 68
 */
public class Offer68 {
    public static void main(String[] args) {
        Offer68 o = new Offer68();
        TreeNode root = Utils.initTreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = Utils.initTreeNode(new Integer[]{2});
        TreeNode q = Utils.initTreeNode(new Integer[]{8});
        //Utils.print(o.lowestCommonAncestor(root, p, q));
        Utils.print(o.lowestCommonAncestor2(root, p, q));
        q = Utils.initTreeNode(new Integer[]{4});
        //Utils.print(o.lowestCommonAncestor(root, p, q));
        Utils.print(o.lowestCommonAncestor2(root, p, q));
    }

    Set<TreeNode> set;
    TreeNode node;

    // I. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.set = new HashSet<>();
        // 从根节点开始检索
        find(root, p.val);
        find(root, q.val);
        return node;
    }

    private void find(TreeNode root, int num) {
        if (set.contains(root)) {
            // 最近的公共祖先
            node = root;
        }
        set.add(root);
        if (root.val > num) {
            find(root.left, num);
        } else if (root.val < num) {
            find(root.right, num);
        }
    }


    // II. 二叉树的最近公共祖先
    // 使用回溯算法；效率有点低
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 从根节点开始检索
        List<TreeNode> l1 = new ArrayList<>();
        find(root, p.val, l1);
        List<TreeNode> l2 = new ArrayList<>();
        find(root, q.val, l2);
        l1.retainAll(l2);
        return l1.get(l1.size() - 1);
    }

    private boolean find(TreeNode root, int num, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            if (root.val != num) {
                if (find(root.left, num, list) || find(root.right, num, list)) {
                    return true;
                } else {
                    list.remove(list.size() - 1);
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
