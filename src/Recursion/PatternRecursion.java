package Recursion;

public class PatternRecursion {
    public static void main(String[] args) {
        Recurrence1(4,0);
        Recurrence2(4, 0);
    }
    public static void Recurrence1(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            System.out.print("*");
            Recurrence1(r, c+1);
        } else {
            System.out.println();
            Recurrence1(r-1, 0);
        }
    }
    public static void Recurrence2(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            Recurrence2(r, c+1);
            System.out.print("*");
        } else {
            Recurrence2(r-1, 0);
            System.out.println();
        }
    }
}
