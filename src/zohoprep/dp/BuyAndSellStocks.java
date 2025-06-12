package zohoprep.dp;

import java.util.Arrays;

class BuyAndSellStocks {
    public static void main(String[] args) {
        int arr[] = { 100, 180, 260, 310, 40, 535, 695 };
        int arr3[] = { 1,2,3,4,5 };
        // System.out.println(maxProfit(arr));
        // System.out.println(stockBuySell(arr));
        System.out.println(maxProfitThree(arr3));
    }

    static int maxProfit(int[] arr) {
        int maxProfit = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }

    static int stockBuySell(int arr[]) {
        // code here
        // We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.
        // ? Buy and sell before buying another stock  

        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    static int maxProfitThree(int[] arr) {
       return 0;
    }
}