package EuclidianAlgorithms;

public class GCDorHCF {
    public static void main(String[] args) {
        int a = 10, b = 5;
        int gcd = gcd(a, b);
        int lcm = (a / gcd) * b;
        System.out.println(lcm+" "+gcd);
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
//    static int gcd(int a, int b){
//        int gcd = 1;
////        for (int i=1;i<=Math.min(a, b);i++){
////            if((a%i==0) && (b%i==0)){
////                gcd =i;
////            }
////        }
////        Optimised one
//        for(int i = Math.min(a, b) ; i>=1 ;i++){
//            if((a%i==0) && (b%i==0)){
//                gcd =i;
//                break;
//            }
//        }
//        return gcd;
//    }
//    static int lcm(int a, int b) {
//        return (a * b) / gcd(a, b);
//    }
}
