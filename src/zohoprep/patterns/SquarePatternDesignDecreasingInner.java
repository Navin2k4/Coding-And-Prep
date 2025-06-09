package zohoprep.patterns;



// You’re given an even number n. If n=4, you have to print the following pattern : 
// 4444 
// 4334 
// 4334 
// 4444
// If n=6, then the pattern should be like this : 
// 666666 
// 655556 
// 654456 
// 654456 
// 655556 
// 666666
public class SquarePatternDesignDecreasingInner {
    public static void main(String[] args) {
        int n = 6;
        printPattern(n);
    }
    static void printPattern(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                int minDistance = n - Math.min(Math.min(i, j), Math.min(n - 1 - i, n - 1 - j));
                System.out.print(minDistance +" ");
            }    
            System.out.println();
        }
    }
}
