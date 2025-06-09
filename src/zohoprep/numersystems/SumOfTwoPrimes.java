package zohoprep.numersystems;

public class SumOfTwoPrimes {
    public static void main(String[] args) {
        int a = 14;
        if (canBeSumOfTwoPrimes(a)) {
            System.out.println(a + " can be expressed as the sum of two prime numbers.");
        } else {
            System.out.println(a + " cannot be expressed as the sum of two prime numbers.");
        }
    }

    static boolean canBeSumOfTwoPrimes(int n) {
        if (n < 4)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                System.out.println("Prime pair: " + i + " + " + (n - i));
                return true;
            }
        }
        return false;
    }

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
