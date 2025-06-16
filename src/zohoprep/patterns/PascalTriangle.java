package zohoprep.patterns;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 6;
        pascalTriangle(n);
    }
    static void pascalTriangle(int n){
        for(int i = 0 ; i< n ;i++){
            // for (int j = n-i; j >=0; j--) {
            //     System.out.print(" ");
            // }
            int C = 1;
            for (int j = 0; j < i; j++) {
                System.out.print(C+" ");
                C = C * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
