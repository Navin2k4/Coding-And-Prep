package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DistinctProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println(findCircleNum(isConnected));
    }

    static int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list (undirected graph)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(adj, i, visited);
            }
        }

        return count;
    }

    static void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(adj, neighbour, visited);
            }
        }
    }
}

// static int findCircleNum(int[][] isConnected) {
// int V = isConnected.length;
// boolean[] visited = new boolean[V];
// int count = 0;

// for (int i = 0; i < V; i++) {
// if (!visited[i]) {
// count++;
// dfs(isConnected, visited, i);
// }
// }

// return count;
// }

// static void dfs(int[][] graph, boolean[] visited, int node) {
// visited[node] = true;
// System.out.print(graph[node][0] + "");
// for (int j = 0; j < graph.length; j++) {
// if (graph[node][j] == 1 && !visited[j]) {
// dfs(graph, visited, j);
// }
// }
// }