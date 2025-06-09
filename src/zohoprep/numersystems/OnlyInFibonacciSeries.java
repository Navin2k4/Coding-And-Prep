package zohoprep.numersystems;

public class OnlyInFibonacciSeries {
    public static void main(String[] args) {
        int arr[] = { 1 ,10 ,6 ,8 ,13 ,21 };
        for(int num:arr){
            if(isPerfectSquare(5*num*num-4)||isPerfectSquare(5*num*num+4)){
                System.out.println(num);
            }
        }
    }

    static boolean isPerfectSquare(int n){
        int s = (int)Math.sqrt(n);
        System.out.println(n);
        return s*s == n;
    }
    
}
