package Trees;

import java.util.LinkedList;
import java.util.Queue;

// Node definition
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// Binary Tree class
class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    // Insert nodes from array using level order insertion
    public void insertLevelOrder(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
            return;

        root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
    }

    // Inorder Traversal (Left -> Root -> Right)
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal (Root -> Left -> Right)
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal (Left -> Right -> Root)
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Search for a node (simple traversal)
    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        return search(root.left, key) || search(root.right, key);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Example input array for level order insertion
        Integer[] elements = { 3, 9, 20, 15, 7 };

        // Build tree from array
        tree.insertLevelOrder(elements);

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root); // Output: 9 3 15 20 7

        System.out.println("\nPreorder traversal:");
        tree.preorder(tree.root); // Output: 3 9 20 15 7

        System.out.println("\nPostorder traversal:");
        tree.postorder(tree.root); // Output: 9 15 7 20 3

        System.out.println("\nSearch 15: " + tree.search(tree.root, 15)); // true
        System.out.println("Search 10: " + tree.search(tree.root, 10)); // false
    }
}
