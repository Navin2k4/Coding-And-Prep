package zohoprep.arrays;

import java.util.*;

class PairWeightProblemOnConditions {
    static final Comparator<Pair> BY_WEIGHT_DESC = (p1, p2) -> Integer.compare(p2.weight, p1.weight);

    static class Pair {
        int num;
        int weight;

        Pair(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 10, 36, 54, 89, 12 };

        List<Pair> result = computeWeight(numbers);
        result.sort((p2, p1) -> Integer.compare(p2.weight, p1.weight));
        // result.sort(BY_WEIGHT_DESC);
        for (Pair pair : result) {
            System.out.println("<" + pair.num + "," + pair.weight + ">");
        }

    }

    static List<Pair> computeWeight(int[] numbers) {
        // 1. 5 if a perfect square
        // 2. 4 if multiple of 4 and divisible by 6
        // 3. 3 if even number
        ArrayList<Pair> ans = new ArrayList<>();
        for (int num : numbers) {
            int weightSum = isPerfectSquare(num) + isValidDivisor(num) + isEven(num);
            ans.add(new Pair(num, weightSum));
        }
        return ans;
    }

    static int isPerfectSquare(int n) {
        int s = (int) Math.sqrt(n);
        if (s * s == n)
            return 5;
        return 0;
    }

    static int isValidDivisor(int n) {
        if (n % 4 == 0 && n % 6 == 0)
            return 4;
        return 0;
    }

    static int isEven(int n) {
        return n % 2 == 0 ? 3 : 0;
    }
}
