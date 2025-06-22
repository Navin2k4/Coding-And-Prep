package DynamicProgramming.Stocks;

public class BuySellOne {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 }; // buy at 1 sell at 6 -> and 5 profit
        System.out.println(maxProfit(arr));
    }

    static int maxProfit(int[] arr) {
        int profit = 0; // starting with 0 profit
        int min = arr[0]; // whatever we buy on first day is the minimum
        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i] - min;
            profit = Math.max(profit, cost); // is this max profit than the prev then update the profit
            min = Math.min(min, arr[i]); // if this is the min trade then update the min trade
            System.out.println("Current : " + arr[i] + " Cost : " + cost + " Profit : " + profit + " Min : " + min);
        }
        return profit;
    }
}
