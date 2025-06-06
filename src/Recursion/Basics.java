package Recursion;

public class Basics {
    static void tailRec(int n){
        if(n==0) return;
        System.out.println(n);
        tailRec(n-1);
    }
    static void headRec(int n){
        if(n==0) return;
        headRec(n-1);
        System.out.println(n);
    }
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
    static int factorial(int n){
        if(n==0 || n==1) return 1;
        return n* factorial(n-1);
    }
    static void printNames(int i, int n){
        if(i > n) return;
        System.out.println("Navin");
        printNames(i+1,n);
    }
    public static void main(String[] args) {
        int n = 5;
       System.out.println("Tail Recursion : "); // Task completed before function call
       tailRec(n);
       System.out.println("Head Recursion : "); // Task completed after function call
       headRec(n);
       System.out.println("Fibonacci Value : " + fib(10));
       System.out.println("Factorial Value : " + factorial(5));
       printNames(1,3);

    }
}
