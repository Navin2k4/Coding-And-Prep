package DynamicProgramming.OneDArray;

import java.util.Arrays;

public class FrogJumpTwo {
    public static void main(String[] args) {

        int arr[] = { 20, 30, 40, 20,10,80 };
        int n = arr.length - 1;
        int k = 3;

        System.out.println(countMinEnergyRec(n, arr, k));

        System.out.println(countMinEnergyTab(arr,k));

        int[] memDP = new int[n + 1];
        Arrays.fill(memDP, -1);
        System.out.println(countMinEnergyMemo(n, arr, memDP,k));

        System.out.println(countMinEnergyOptimized(arr,k));
    }

    static int countMinEnergyRec(int n, int arr[], int k) {

        if (n == 0)
            return 0;

        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int energy = countMinEnergyRec(n - i, arr, k) + Math.abs(arr[n] - arr[n - i]);
                minEnergy = Math.min(minEnergy, energy);
            }
        }

        return minEnergy;
    }

    static int countMinEnergyMemo(int n, int[] arr, int[] memDP, int k) {
        if (n == 0)
            return 0;

        if (memDP[n] != -1)
            return memDP[n];

        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int energy = countMinEnergyMemo(n - i, arr, memDP, k) + Math.abs(arr[n] - arr[n - i]);
                minEnergy = Math.min(minEnergy, energy);
            }
        }

        return memDP[n] = minEnergy;
    }

    static int countMinEnergyTab(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int energy = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minEnergy = Math.min(minEnergy, energy);
                }
            }
            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }

    static int countMinEnergyOptimized(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[k + 1]; // Circular buffer
        Arrays.fill(dp, 0);

        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int energy = dp[(i - j) % (k + 1)] + Math.abs(arr[i] - arr[i - j]);
                    minEnergy = Math.min(minEnergy, energy);
                }
            }
            dp[i % (k + 1)] = minEnergy;
        }

        return dp[(n - 1) % (k + 1)];
    }
}
