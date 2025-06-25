package Arrays;
// LC 1732

public class FindtheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int total = 0;
        for (int i = 0; i < gain.length; i++) {
            total += gain[i];
            if (total > highest) {
                highest = total;
            }
        }
        return highest;
    }
}
