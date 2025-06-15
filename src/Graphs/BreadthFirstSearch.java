package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Level Wise traversal technique
// Distance between the nodes represent the level for the curent node
public class BreadthFirstSearch {
    // Queue Data Structure FIFO
    // Visited Array

    static ArrayList<Integer> BFS(List<List<Integer>> graph, int V) {
        System.out.println("Vertices : " + graph.size());
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        // Add the initial node we are starting to search

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);
            for (int neighbour : graph.get(node)) {
                if (visited[neighbour] == false) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 10;
        for (int i = 1; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        adjList.get(1).add(6);
        adjList.get(6).add(1);

        adjList.get(2).add(3);
        adjList.get(3).add(2);

        adjList.get(2).add(4);
        adjList.get(4).add(2);

        adjList.get(6).add(7);
        adjList.get(7).add(6);

        adjList.get(6).add(9);
        adjList.get(9).add(6);

        adjList.get(4).add(5);
        adjList.get(5).add(4);

        adjList.get(7).add(8);
        adjList.get(8).add(7);
        // for (int i = 0; i < n; i++) {
        // System.out.print("Node " + i + " : ");
        // for (int neighbours : adjList.get(i)) {
        // System.out.print(neighbours + " ");
        // }
        // System.out.println();
        // }
        System.out.println(BFS(adjList, n).toString());
    }

}
