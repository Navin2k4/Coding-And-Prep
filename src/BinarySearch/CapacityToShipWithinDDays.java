package BinarySearch;

public class CapacityToShipWithinDDays {
    public static void main(String[] args) {
        // System.out.println(shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        // }, 5));
        // System.out.println(shipWithinDays(new int[] { 3, 2, 2, 4, 1, 4 }, 3));
        System.out.println(shipWithinDays(new int[] { 1, 2, 3, 1, 1 }, 4));
    }

    static int shipWithinDays(int[] weights, int days) {
        int low = maxWeight(weights);
        int high = calculateSum(weights);
        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            System.out.println(mid);
            int currentDays = calculateDays(weights, mid);
            System.out.println("Required Days : " + currentDays);
            // break;
            if (currentDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int maxWeight(int[] weights) {
        int max = weights[0];
        for (int w : weights)
            max = Math.max(max, w);
        return max;
    }

    static int calculateSum(int[] weights) {
        int totalWeights = 0;
        for (int i = 0; i < weights.length; i++) {
            totalWeights += weights[i];
        }
        return totalWeights;
    }

    static int calculateDays(int[] weights, int capacity) {
        int totalWeight = 0;
        int totalDays = 1;
        for (int weight : weights) {
            // Consider weather the capacity can be includeed before adding them up
            if (totalWeight + weight > capacity) {
                totalDays++;
                totalWeight = weight;
            } else {
                totalWeight += weight;
            }

            // System.out.println("Total Days : " + totalDays);
        }
        return totalDays;
    }
}
