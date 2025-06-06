package Trees;

public class DiameterOfBinaryTree {
    static int maxHeight(Node root, int[] diameter) {
        if (root == null) return 0;
        int leftHeight = maxHeight(root.left, diameter);
        int rightHeight = maxHeight(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static int findDiameter(Node root) {
        int[] diameter = new int[1];
        maxHeight(root, diameter);
        return diameter[0];
    }

    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree();
        BinaryTree tree2 = TreeBuilder.buildSampleTree2();
        System.out.println(findDiameter(tree.root));
        System.out.println(findDiameter(tree2.root));
    }
}
