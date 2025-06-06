package zohoprep.arrays;

public class SecondMaximum {
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,2};
        System.out.println(secondMaximum(arr));
        // System.out.println(secondSmallest(arr));
    }
    static int secondMaximum(int[] arr){
        if (arr.length < 2) return -1;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
    static int secondSmallest(int[] arr){
        if (arr.length < 2) return -1;
        // Brute sort and find the second largest from traversing from last
        // Better to pass firstLargest and then secondlargest
        // optimaltwo variable one for largest one for second largest check in one iteration itself
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }
        return (secondSmallest == Integer.MAX_VALUE) ? -1 : secondSmallest;
    }
}
