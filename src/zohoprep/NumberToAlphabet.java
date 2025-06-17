package zohoprep;

public class NumberToAlphabet {
    public static void main(String[] args) {
        System.out.println(convertToAlphabet(1)); // A
        System.out.println(convertToAlphabet(26)); // Z
        System.out.println(convertToAlphabet(27)); // AA
        System.out.println(convertToAlphabet(702)); // ZZ
        System.out.println(convertToAlphabet(703)); // AAA
        System.out.println(convertToAlphabet(18278)); // ZZZ
    }

    public static String convertToAlphabet(int number) {
        StringBuilder sb = new StringBuilder();
        // Not an 0 based so reduce 1 before calculating

        while (number > 0) {
            number--;
            int rem = number % 26;
            sb.append((char) ('A' + rem));
            number /= 26;
        }

        return sb.toString();
    }
}
