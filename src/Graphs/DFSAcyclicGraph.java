import java.util.*;

public class DFSAcyclicGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {1,2}, {1,3}};
        int V = 4;

        // Step 1: Build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>()); // undirected
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // undirected
        }

        // Step 2: Visited set
        Set<Integer> visited = new HashSet<>();

        // Step 3: Call DFS from node 0
        dfs(0, graph, visited);
    }

    public static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.println("Visited: " + node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(neighbor, graph, visited);
        }
    }
}
