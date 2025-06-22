package DynamicProgramming.OneDArray;

import java.util.Arrays;

public class FrogJumpOne {
    public static void main(String[] args) {

        int arr[] = { 20, 30, 40, 20 };
        int n = arr.length - 1;

        // System.out.println(countMinEnergyRec(n, arr));

        System.out.println(countMinEnergyTab(arr));

        int[] memDP = new int[n + 1];
        Arrays.fill(memDP, -1);
        System.out.println(countMinEnergyMemo(n, arr, memDP));

        System.out.println(countMinEnergyVariables(arr));
    }

    static int countMinEnergyRec(int n, int arr[]) {

        if (n == 0)
            return 0;

        int left = countMinEnergyRec(n - 1, arr) + Math.abs(arr[n] - arr[n - 1]);
        int right = Integer.MAX_VALUE;

        if (n > 1) {
            right = countMinEnergyRec(n - 2, arr) + Math.abs(arr[n] - arr[n - 2]);
        }
        return Math.min(left, right);
    }

    static int countMinEnergyMemo(int n, int[] arr, int[] memDP) {
        if (n == 0)
            return 0;

        if(memDP[n] != -1) return memDP[n];

        int left = countMinEnergyMemo(n - 1, arr, memDP) + Math.abs(arr[n] - arr[n - 1]);
        int right = Integer.MAX_VALUE;

        if (n > 1) {
            right = countMinEnergyMemo(n - 2, arr, memDP) + Math.abs(arr[n] - arr[n - 2]);
        }
        return memDP[n] = Math.min(left, right);
    }

    static int countMinEnergyTab(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 0;
        if (n > 2) {
            dp[1] = Math.abs(arr[1] - arr[0]);
        }

        for (int i = 2; i < n; i++) {
            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            dp[i] = Math.min(left, right);
            System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    static int countMinEnergyVariables(int[] arr){
        int n = arr.length;
        int prev = 0;
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int fs = prev + Math.abs(arr[i] - arr[i - 1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1){
                ss = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }
            int current = Math.min(ss, fs);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

}
