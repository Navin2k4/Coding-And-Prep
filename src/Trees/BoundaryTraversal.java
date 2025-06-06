package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversal {

    // * Left boundary traversal without the leaf nodes */
    // * Gather leaf nodes using the inorder traversal */
    // * Roght boundary traversal without the leaf nodes */

    static boolean isLeaf(Node node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    static void addLeftBoundary(Node node, ArrayList<Integer> answer) {
        Node current = node.left;
        while (current != null) {
            if (isLeaf(current) == false) {
                answer.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    static void addLeaves(Node node, ArrayList<Integer> answer) {
        if (isLeaf(node)) {
            answer.add(node.data);
        }
        if (node.left != null)
            addLeaves(node.left, answer);
        if (node.right != null)
            addLeaves(node.right, answer);
    }

    static void addRightBoundary(Node node, ArrayList<Integer> answer) {
        Node current = node.right;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            if (isLeaf(current) == false) {
                stack.push(current.data);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }
    }

    static ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (isLeaf(node) == false)
            result.add(node.data);
        addLeftBoundary(node, result);
        addLeaves(node, result);
        addRightBoundary(node, result);
        return result;

    }

    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree();
        System.out.println(boundaryTraversal(tree.root));
    }
}
