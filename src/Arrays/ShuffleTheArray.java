package Arrays;
// LC 1470
public class ShuffleTheArray {
        public int[] shuffle(int[] nums, int n) {
            int firstHalf[] = new int[nums.length / 2];
            int secondHalf[] = new int[nums.length / 2];
            int res[] = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i < n) {
                    firstHalf[i] = nums[i];
                } else {
                    secondHalf[i - n] = nums[i];
                }
            }
            for (int i = 0; i < n; i++) {
                res[2 * i] = firstHalf[i];
                res[2 * i + 1] = secondHalf[i];
            }
            return res;
        }
    }

