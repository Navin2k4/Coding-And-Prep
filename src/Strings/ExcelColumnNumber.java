package Strings;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        String columnTitle = "AA";
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            int value = ch - 'A' + 1;
            result = result * 26 + value;
        }
        System.out.println(result);
    }
}
