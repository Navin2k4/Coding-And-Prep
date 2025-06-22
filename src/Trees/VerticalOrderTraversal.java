package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

class Tuple {
    Node node;
    int row;
    int col;

    public Tuple(Node node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        BinaryTree tree = TreeBuilder.buildSampleTree();
        System.out.println(verticalOrderTraversal(tree.root));
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> collection = new ArrayList<>();
        TreeMap<Integer, Map<Integer, List<Integer>>> treeMap = new TreeMap<>();
        inorderTraversal(root, treeMap, 0, 0);
        for (var colEntry : treeMap.entrySet()) {
            List<Integer> list = new ArrayList<>();
            for (var rowValues : colEntry.getValue().values()) {
                Collections.sort(rowValues);
                list.addAll(rowValues);
            }
            collection.add(list);
        }
        return collection;
    }

    static void inorderTraversal(Node node, TreeMap<Integer, Map<Integer, List<Integer>>> treeMap, int column,
            int row) {

        if (node == null) {
            return;
        }

        treeMap.computeIfAbsent(column, k -> new TreeMap<>()).computeIfAbsent(row, k -> new ArrayList<>())
                .add(node.data);

        inorderTraversal(node.left, treeMap, column - 1, row + 1);
        inorderTraversal(node.right, treeMap, column + 1, row + 1);
    }

    static List<List<Integer>> verticalOrderTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    System.out.println(nodes.peek());
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }
        return res;
    }

}
