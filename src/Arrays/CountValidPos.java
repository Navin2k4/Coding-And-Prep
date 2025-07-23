public class CountValidPos {
    public static void main(String[] args) {
        int n = 2;
        int[] arr = { 3, 5 };
        System.out.println(countValidFun(n, arr));
    }
    
    static int countValidFun(int n, int[] arr) {
        int dig[] = new int[n+1];
        dig[0] = 9;
        for (int i = 1; i <= n; i++) {
            dig[i] = dig[i-1] * 10;
        }
        System.out.println(dig[n - 1]);
        // 0 - 9
        int countPos = 0;
        if (n == 1) {
            return arr.length;
        }
        
        if (n > 1) {
            countPos += 7;
        }

        for (int i = 1; i < n; i++) {
            countPos *= 8;
        }
        System.out.println(countPos);

        
        return dig[n-1]-countPos;

    }
}
