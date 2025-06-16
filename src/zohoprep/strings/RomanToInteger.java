package zohoprep.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        // System.out.println(romanToInt("IX")); // 9
        // System.out.println(romanToInt("LVIII")); // 58
        // System.out.println(romanToInt("MCMXCIV")); // 1994

        // System.out.println(intToRoman(9)); // IX
        System.out.println(intToRoman(58)); // LVIII
        // System.out.println(intToRoman(1994)); // MCMXCIV
    }

    static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        /*
         * Loop from right to left of the string.
         * Keep a running total.
         * Add if current value ≥ previous value, else subtract.
         */
        int total = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = romanMap.get(s.charAt(i));

            if (curr < prev) {
                total -= curr;
            } else {
                total += curr;
            }

            prev = curr;
        }
        return total;
    }

    static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                System.out.println(num);
                num -= values[i];
                result.append(romans[i]);
            }
        }
        return result.toString();
    }

}
