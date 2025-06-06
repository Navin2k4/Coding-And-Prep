package Trees;

public class HeightOfBinaryTree {
    static int maxHeight(Node root){
        if (root == null ) return 0;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight) ;
    }
    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree(); 
        System.out.println(maxHeight(tree.root));
    }
}
