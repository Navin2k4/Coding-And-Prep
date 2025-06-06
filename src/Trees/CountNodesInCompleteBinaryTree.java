package Trees;


public class CountNodesInCompleteBinaryTree {
    static int countNodes(Node root) {
        return 0;
    }
    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree();
        System.out.println(countNodes(tree.root));
    }   
}
