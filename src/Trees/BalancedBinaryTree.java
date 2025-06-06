package Trees;

public class BalancedBinaryTree {
    static int maxHeight(Node root){
        if(root == null) return 0;
        int leftHeight = maxHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = maxHeight(root.right);
        if(rightHeight == -1) return -1;
        if(Math.abs(leftHeight-rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static boolean isBalanced(Node root){
        return maxHeight(root) != -1;
    }
    
    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree();
        System.out.println(isBalanced(tree.root));
    }
    
}
