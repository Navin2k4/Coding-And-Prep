package Trees;

public class SymmetricTree {
    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree();
        System.out.println(isSymmetric(tree.root));
    }   
    static boolean isSymmetric(Node root) {
        // Code here
        return root == null || isMirror(root.left, root.right);
    }
    static boolean isMirror(Node left, Node right){
        if(left == null || right==null) return left==right;
        if(left.data != right.data) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
