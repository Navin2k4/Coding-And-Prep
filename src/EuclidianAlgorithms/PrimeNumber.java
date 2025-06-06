package EuclidianAlgorithms;

public class PrimeNumber {
    public static void main(String[] args) {
//        number with exactly 2 factors 1 and itself
//        Brute force run from 1 to n and find its divisors count if count is == 2 then prime else not a prime
//        TC is O(n)
        int n = 14;
        int count = 0;
        for( int i = 1 ;i*i<=n;i++){
            if(n%i==0){
                count++;
                if((n/i)!=i){
                    count++;
                }
            }
        }
        System.out.println(count == 2);
    }
}
