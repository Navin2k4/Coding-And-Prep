package zohoprep.numersystems;

public class PerfectPrime {
    public static void main(String[] args) {
        int number = 49;
        System.out.println(isPerfectPrime(number));  // Output: true

        number = 7;
        System.out.println(isPerfectPrime(number));  // Output: false
    }
     static boolean isPerfectPrime(int num) {
        if(num <= 1 ) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
