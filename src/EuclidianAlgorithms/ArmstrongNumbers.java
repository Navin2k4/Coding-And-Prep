package EuclidianAlgorithms;

public class ArmstrongNumbers {
    public static void main(String[] args) {
        int n = 371;
        System.out.println(isArmstrong(n));
    }
    static boolean isArmstrong(int n){
        if(n < 0) return false;
        int original = n;
        int armstrong = 0;
        while(n > 0){
            int last = n % 10;
            armstrong += (int)Math.pow(last,3);
            n = n /10;
        }
        return original == armstrong;
    }
}
