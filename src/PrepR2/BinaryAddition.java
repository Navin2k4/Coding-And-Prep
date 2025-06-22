public class BinaryAddition {
    public static void main(String[] args) {
        String a = "10011";
        String b = "11000";
        System.out.println("Sum: " + addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = bitA + bitB + carry;
            result.append(sum % 2); // current bit
            carry = sum / 2; // new carry
        }

        return result.reverse().toString();
    }
}
