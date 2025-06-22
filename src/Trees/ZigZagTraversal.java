package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ZigZagTraversal {
     public List<List<Integer>> zigzagLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        queue.offer(root);
        boolean flag = false; 
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (flag) {
                    subList.add(0, node.data);
                } else {
                    subList.add(node.data);
                }
            }
            result.add(subList);
            flag = !flag;
        }
        return result;
    }    
}
