package EuclidianAlgorithms;

public class FindAllDivisors {
    public static void main(String[] args) {
        int n = 36;
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println();

//      TC:  O(sqrt(n))
        for (int i=1; i<= Math.sqrt(n);i++){
//        for (int i=1;  i*i <= n ;i++){
            if( n% i ==0 ){
                System.out.println(i + " ");
                if((n/i)!=i){
                    System.out.println(n/i);
                }
            }
        }
    }
}
