package org.azhell.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 */
public class NAryTreePreorderTraversal {

    List<Integer> result;

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
