package zohoprep.patterns;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 6;
        pascalTriangle(n);
    }
    static void pascalTriangle(int n){
        for(int i = 1 ; i<=n ;i++){
            for (int j = n-i; j >=0; j--) {
                System.out.print(" ");
            }
            int C = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(C+" ");
                C = (int) (C * (i-j) / j);
            }
            System.out.println();
        }
    }
}
