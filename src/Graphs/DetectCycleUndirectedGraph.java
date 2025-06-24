package Graphs;

import java.util.*;

public class DetectCycleUndirectedGraph {

    static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[V];


        // what if this is a non connnected component so we need to call all the one which are not visited
        for (int node = 0; node < V; node++) {
            if (!visited[node]) {
                if (bfsCheckCycle(node, adjList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfsCheckCycle(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int node = current.node;
            int parent = current.parent;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new Pair(neighbor, node));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCycleUndirectedGraph obj = new DetectCycleUndirectedGraph();
        int V = 4;
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 2, 3 }
        };

        boolean hasCycle = obj.isCycle(V, edges);
        System.out.println("Graph contains cycle? " + hasCycle);
    }
}
