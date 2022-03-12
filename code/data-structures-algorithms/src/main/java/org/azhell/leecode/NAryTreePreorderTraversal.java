package org.azhell.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * 590. N 叉树的后序遍历
 */
public class NAryTreePreorderTraversal {

    List<Integer> result;

    // 前序遍历
    public List<Integer> preorder(Node root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderHelper(root);
        return result;
    }

    private void preorderHelper(Node node) {
        if (node != null) {
            result.add(node.val);
            for (Node child : node.children) {
                preorderHelper(child);
            }
        }
    }

    // 后序遍历
    public List<Integer> postorder(Node root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorderHelper(root);
        return result;
    }

    private void postorderHelper(Node node) {
        if (node.children != null) {
            for (Node child : node.children) {
                postorderHelper(child);
            }
        }
        result.add(node.val);
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
