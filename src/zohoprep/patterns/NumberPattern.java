package zohoprep.patterns;

public class NumberPattern {
    public static void main(String[] args) {
        int n = 4;
        PrintPatternNumber(n);

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
