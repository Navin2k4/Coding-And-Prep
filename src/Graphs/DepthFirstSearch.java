package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    static void DFSIterative(List<List<Integer>> adjList, int V, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.println(node + " ");
                List<Integer> neighbours = adjList.get(node);
                Collections.reverse(neighbours);
                for (int neighbour : neighbours) {
                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                    }
                }
                Collections.reverse(neighbours);
            }
        }
    }

    static ArrayList<Integer> DFS(List<List<Integer>> graph, int V) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        visited[1] = true;
        dfsHelper(1, visited, graph, res);
        return res;
    }

    static void dfsHelper(int node, boolean[] vis, List<List<Integer>> graph, ArrayList<Integer> res) {
        vis[node] = true;
        res.add(node);
        for (int neighbour : graph.get(node)) {
            if (vis[neighbour] == false) {
                dfsHelper(neighbour, vis, graph, res);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 9;
        for (int i = 1; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        adjList.get(1).add(3);
        adjList.get(3).add(1);

        adjList.get(2).add(5);
        adjList.get(5).add(2);

        adjList.get(2).add(6);
        adjList.get(6).add(2);

        adjList.get(3).add(4);
        adjList.get(4).add(3);

        adjList.get(3).add(7);
        adjList.get(7).add(3);

        adjList.get(4).add(8);
        adjList.get(8).add(4);

        adjList.get(7).add(8);
        adjList.get(8).add(7);
        // for (int i = 0; i < n; i++) {
        // System.out.print("Node " + i + " : ");
        // for (int neighbours : adjList.get(i)) {
        // System.out.print(neighbours + " ");
        // }
        // System.out.println();
        // }
        System.out.println(DFS(adjList, n).toString());
        DFSIterative(adjList, n, 1);
    }
}
