package EuclidianAlgorithms;

public class CountOfDigits {
    public static void main(String[] args) {
        int n = 12132;
//        int count = 0;
//        while (n>0){
//            int last = n % 10 ;
//            count++;
//            n = n /10;
//        }
//        System.out.println("Count is " + count);
        int countLog = (int) Math.log10(n) + 1;
        System.out.println("Count using Log : " + countLog);
    }
}
//Time Complexity => (log10(n))
// If it is based on the division then the time complexity is of logarithmic. log()
