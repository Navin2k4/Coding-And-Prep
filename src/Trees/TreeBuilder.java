package Trees;

public class TreeBuilder {
    public static BinaryTree buildSampleTree() {
        BinaryTree tree = new BinaryTree();
        Integer[] elements = { 10 ,20 ,30 , 10, 10};
        tree.insertLevelOrder(elements);
        return tree;
    }
    public static BinaryTree buildSampleTree2() {
        BinaryTree tree = new BinaryTree();
        Integer[] elements = { 3, 1, 2 };
        tree.insertLevelOrder(elements);
        return tree;
    }
}
