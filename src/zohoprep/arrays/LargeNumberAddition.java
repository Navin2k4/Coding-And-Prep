package zohoprep.arrays;

import java.util.ArrayList;

public class LargeNumberAddition {

    public static void main(String[] args) {
        int[] num1 = {9, 2, 8, 1, 3, 5, 6, 7, 3, 1, 1, 6}; // 12 digits
        int[] num2 = {7, 8, 4, 6, 2, 1, 9, 9, 7};           // 9 digits
        // int[] result = addLargeNumbers(num1, num2);
        int[] OPresult = addLargeNumbersOPLogic(num1, num2);
        for (int digit : OPresult) {
            System.out.print(digit + " ");
        }
    }

    public static int[] addLargeNumbers(int[] num1, int[] num2) {
        // Your logic to be implemented here
        ArrayList<Integer> ans = new ArrayList<>();

        int i = num1.length - 1;
        int j = num2.length - 1;
        int maxLoop = Math.max(num1.length, num2.length);
        int carry = 0;
        while (maxLoop > 0) {
            if (i >= 0 && j >= 0) {
                int sum = num1[i] + num2[j] + carry;
                if (sum > 9) {
                    int addOn = sum % 10;
                    int rem = sum / 10;
                    sum = addOn;
                    carry = rem;
                } else {
                    carry = 0;
                }
                ans.add(sum);
                i--;
                j--;
            }
            maxLoop--;
        }
        while (i >= 0) {
            int sum = num1[i] + carry;
            if (sum > 9) {
                ans.add(sum % 10);
                carry = sum / 10;
            } else {
                ans.add(sum);
                carry = 0;
            }
            i--;
        }

        while (j >= 0) {
            int sum = num2[j] + carry;
            if (sum > 9) {
                ans.add(sum % 10);
                carry = sum / 10;
            } else {
                ans.add(sum);
                carry = 0;
            }
            j--;
        }

        if (carry > 0) {
            ans.add(carry);
        }

        int[] result = new int[ans.size()];
        for (int ind = 0; ind < ans.size(); ind++) {
            result[ind] = ans.get(ans.size() - 1 - ind);
        }
        return result;
    }

    public static int[] addLargeNumbersOPLogic(int[] num1, int[] num2) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = num1.length - 1;
        int j = num2.length - 1;
        int carry = 0;

        // Core addition loop — single pass for all cases
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1[i--] : 0;
            int digit2 = (j >= 0) ? num2[j--] : 0;

            int sum = digit1 + digit2 + carry;
            ans.add(sum % 10);
            carry = sum / 10;
        }

        // Convert reversed ArrayList to int[]
        int[] result = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(ans.size() - 1 - k); // reverse it
        }

        return result;
    }
}
