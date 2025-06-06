package Trees;

public class SumTree {
    static boolean isSumTree(Node root) {
        if(root == null) return false;
        // Your code here
        // what traversal can give me root left and right ? => preorder
        return checkSumTree(root) != -1;
    }

    static int checkSumTree(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;

        int leftSum = checkSumTree(root.left);
        int rightSum = checkSumTree(root.right);

        if(leftSum == -1 || rightSum == -1) return -1;

        if(root.data == leftSum + rightSum){
            return root.data + leftSum + rightSum; 
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree();
        tree.postorder(tree.root);
        System.out.println(isSumTree(tree.root));
    }
}
