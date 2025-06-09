package Trie;

class KthSmallestInLexicographicalNumber {

    public static void main(String[] args) {
        System.out.println(findKthNumber(100,10));
    }
    static int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            long steps = countSteps(curr, n);
            // System.out.println("Steps :" +steps);
            if (steps <= k) {
                curr += 1;   
                k -= steps; 
            } else {
                curr *= 10; 
                k -= 1;     
            }
        }
        return curr;
    }

    static long countSteps(long curr, long n) {
        long steps = 0;
        long first = curr;
        long last = curr;

        while (first <= n) {
            steps += Math.min(n, last) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }

        return steps;
    }
}
