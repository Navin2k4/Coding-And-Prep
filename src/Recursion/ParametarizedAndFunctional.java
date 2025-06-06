package Recursion;


public class ParametarizedAndFunctional {
    static void printSumParametarized(int n, int sum){
        if( n < 1){
            System.out.println(sum);
            return;
        }
        printSumParametarized(n-1, sum+n);
    }
    static int printSumFunctional(int n){
        if(n == 0) return 0;
        return n + printSumFunctional(n-1);
    }
    public static void main(String[] args) {
        // Sum of first N Numbers
        // pass only the n in the function
        System.out.println("By Functional : " + printSumFunctional(3));
        // pass the output varuable sum in the function
        System.out.print("By Parameter : ");
        printSumParametarized(3,0);
    }

}
