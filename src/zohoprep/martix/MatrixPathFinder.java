package zohoprep.martix;

import java.util.ArrayList;
import java.util.List;

public class MatrixPathFinder {

    static int[][] grid = {
            { 1, 1, 0, 0 },
            { 1, 0, 0, 1 },
            { 1, 1, 1, 1 },
            { 0, 0, 0, 1 }
    };

    static int N = grid.length;

    static int[] FourDirectionX = { 1, -1, 0, 0 };
    static int[] FourDirectionY = { 0, 0, 1, -1 };
    static int[] EightDirectionX = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] EightDirectionY = { -1, 0, 1, 1, 1, 0, -1, -1 };

    public static void main(String[] args) {
        List<List<String>> allPaths = findAllPaths(grid);
        System.out.println("All Paths:");
        for (List<String> path : allPaths) {
            System.out.println(path);
        }

        int shortestDistance = findShortestPathDistance(grid);
        System.out.println("Shortest Distance: " + shortestDistance);

        System.out.println("Traversal Path:");
        printTraversalPath(grid);
    }

    private static List<List<String>> findAllPaths(int[][] grid) {

        return new ArrayList<>();

    }

    private static int findShortestPathDistance(int[][] grid) {
        return -1;
    }

    private static void printTraversalPath(int[][] grid) {

    }

}