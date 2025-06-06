package BackTracking;

import java.util.ArrayList;

public class MageProblem {
    public static void main(String[] args) {
        boolean board[][] = {
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
        System.out.println(CountWays(3, 3));
        pathWays("", 3, 3);
        System.out.println(pathWaysArrWithDiagonal("", 3, 3));
        pathWaysWithObstacles("", board, 0, 0);
    }

    // Counting the number of ways we can traverse
    static int CountWays(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int left = CountWays(r, c-1);
        int right = CountWays(r-1, c);
        return left+right;
    }
    
    // Display all the paths that it can be traversed
    static void pathWays(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1)     pathWays(p+'D',r-1, c);
        if(c > 1)   pathWays(p+'R',r, c-1);
    } 
    
    // Return as an array list
    static ArrayList<String> pathWaysArr(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>(); 
        if(r>1)     ans.addAll(pathWaysArr(p+'D',r-1, c));
        if(c > 1)   ans.addAll(pathWaysArr(p+'R',r, c-1));
        return ans;
    }
    
    // Adding new direction diagonal
    static ArrayList<String> pathWaysArrWithDiagonal(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>(); 
        if(r>1 || c>1)  ans.addAll(pathWaysArrWithDiagonal(p+"D",r-1,c-1));
        if(r>1)         ans.addAll(pathWaysArrWithDiagonal(p+"H",r-1, c));
        if(c > 1)       ans.addAll(pathWaysArrWithDiagonal(p+"R",r, c-1));
        return ans;
    }

    // Display all the paths but has an obstacle here used an boolean matrix F denotes blocakage of path that it can be traversed
    static void pathWaysWithObstacles(String p,boolean maze[][],int r,int c){
        if( r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) return; 
        if(r < maze.length-1)       pathWaysWithObstacles(p+'D',maze,r+1, c);
        if(c < maze[0].length-1)    pathWaysWithObstacles(p+'R',maze,r, c+1);
    } 
}
