package zohoprep.patterns;

class BinaryValuesPattern {
    public static void main(String[] args) {
        int n = 3;
        printBinaryPatternInBuiltFunctions(n);
        System.out.println();
        printBinaryPattern(n);
    }

    static void printBinaryPattern(int n) {
        int totalCombinations = 1 << n;

        for (int i = 0; i < totalCombinations; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int bit = (i >> j) & 1;
                System.out.print(bit);
                if (j != 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void printBinaryPatternInBuiltFunctions(int n) {
        int totalCombinations = (int) Math.pow(2, n);
        for (int i = 0; i < totalCombinations; i++) {
            String binary = Integer.toBinaryString(i);
            String padded = String.format("%" + n + "s", binary).replace(' ', '0');
            String spaced = String.join(" ", padded.split(""));
            System.out.println(spaced);
        }
    }
}