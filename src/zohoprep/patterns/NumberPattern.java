package zohoprep.patterns;

public class NumberPattern {
    public static void main(String[] args) {
        int n = 4;
        PrintPatternNumber(n);
/*
 *    1 
  3 2 
 6 5 4 
10 9 8 7 
10 9 8 7 
 6 5 4 
  3 2 
   1 
 */
    }

    static void PrintPatternNumber(int n) {
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            int start = (i * (i + 1)) / 2;
            for (int num = start; num > start - i; num--) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            int start = (i * (i + 1)) / 2;

            for (int num = start; num > start - i; num--) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
