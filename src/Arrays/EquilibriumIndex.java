package Arrays;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {5,2,8,2,3,2};
        System.out.println(findIndex(arr));
    }
    static int findIndex(int[] arr){
        int n = arr.length;
        int[] presum = new int[arr.length];
        int[] sufsum = new int[arr.length];
        presum[0] = arr[0];
        sufsum[n-1] = arr[n-1];

        

        return -1;
    }
}
