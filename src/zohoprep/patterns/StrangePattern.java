package zohoprep.patterns;

// n = 6
// 1 7  12 16 19 21
// 2 8  13 17 20
// 3 9  14 18
// 4 10 15
// 5 11
// 6
public class StrangePattern {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n - i; j++) {
                int start = 1 + j * n - (j * (j - 1)) / 2;
                int val = start + i;
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
