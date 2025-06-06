package Trees;

public class MaxPathSum {

    static int maxPath(Node root, int[] maxPath) {
        if (root == null) return 0;
        int leftPath = Math.max(0, maxPath(root.left, maxPath));
        int rightPath = Math.max(0, maxPath(root.right, maxPath));
        maxPath[0] = Math.max(maxPath[0], leftPath + rightPath + root.data);
        return root.data + Math.max(leftPath, rightPath);
    }

    static int maximumPathSum(Node root) {
        int maximum[] = new int[1];
        maximum[0] = Integer.MIN_VALUE;
        maxPath(root, maximum);
        return maximum[0];
    }

    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree();
        System.out.println(maximumPathSum(tree.root));
        BinaryTree tree2 = TreeBuilder.buildSampleTree2();
        System.out.println(maximumPathSum(tree2.root));
    }

}
