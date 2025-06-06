package BackTracking;

import java.util.Arrays;

public class AllPathMaze {
    public static void main(String[] args) {
        boolean board[][] = {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };

        int[][] path = new int[board.length][board[0].length];
        // allPathSolved("", board, 0, 0);
        allPathDisplayWithMatrix("", board, 0, 0, path, 1);
    }

    // This will cause in the recursion stack overflow 
    static void allPathWithProblemStackOverFlow(String p,boolean maze[][],int r,int c){
        if( r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) return;
        if(r < maze.length-1)       allPathWithProblemStackOverFlow(p+'D',maze,r+1, c);
        if(c < maze[0].length-1)    allPathWithProblemStackOverFlow(p+'R',maze,r, c+1);
        if(r > 0)                   allPathWithProblemStackOverFlow(p+'U',maze,r-1, c);
        if(c > 0)                   allPathWithProblemStackOverFlow(p+'L',maze,r, c-1);
    } 
    
    static void allPathSolved(String p,boolean maze[][],int r,int c){
        if( r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) return;
        // this is where the recursion call starts and setting the current col and row to false it visited
        maze[r][c] = false; //! Make the change
            if(r < maze.length-1)       allPathSolved(p+'D',maze,r+1, c);
            if(c < maze[0].length-1)    allPathSolved(p+'R',maze,r, c+1);
            if(r > 0)                   allPathSolved(p+'U',maze,r-1, c);
            if(c > 0)                   allPathSolved(p+'L',maze,r, c-1);
        maze[r][c] = true;  //! Revert the change
        // This line is where all the recursion of a call ends and revert the changes made before the recursion call made backtracked
    } 

    static void allPathDisplayWithMatrix(String p,boolean maze[][],int r,int c,int path[][], int step){
        if( r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]) return;   
        maze[r][c] = false;
        path[r][c] = step;
            if(r < maze.length-1)       allPathDisplayWithMatrix(p+'D',maze,r+1, c,path,step+1);
            if(c < maze[0].length-1)    allPathDisplayWithMatrix(p+'R',maze,r, c+1,path,step+1);
            if(r > 0)                   allPathDisplayWithMatrix(p+'U',maze,r-1, c,path,step+1);
            if(c > 0)                   allPathDisplayWithMatrix(p+'L',maze,r, c-1,path,step+1);
        maze[r][c] = true;
        path[r][c] = 0;  
    } 
}
