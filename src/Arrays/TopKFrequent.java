package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequent {
    public static void main(String[] args) {
        // int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int arr2[] = { 1, 1, 2, 2, 3, 3, 3, 4 };
        topKFrequent(arr2, 2);
        topKFrequentOrdered(arr2, 2);
    }

    // Order specific
    static ArrayList<Integer> topKFrequentOrdered(int[] arr, int k) {
        // Your code here
        // Counting frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Max heap sorted by frequency, then by value descending
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (b[1] != a[1])
                        return b[1] - a[1];
                    else
                        return b[0] - a[0];
                });

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[] { entry.getKey(), entry.getValue() });
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            result.add(pq.poll()[0]);
        }

        System.out.println((result).toString());
        return null;
    }

    // Order not needed
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            int number = entry.getKey();
            bucket[frequency].add(number);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = nums.length; i >= 0 && resultList.size() < k; i--) {
            if (!bucket[i].isEmpty()) {
                resultList.addAll(bucket[i]);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = resultList.get(i);
        }

        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        return null;
    }
}
