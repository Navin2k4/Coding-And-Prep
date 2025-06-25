package Strings;

public class ExcelColumName {
    public static void main(String[] args) {
        int columnNumber = 123;
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            char ch = (char) ('A' + rem);
            sb.append(ch);
            columnNumber /= 26;
        }
        System.out.println(sb.reverse().toString());
    }
}
