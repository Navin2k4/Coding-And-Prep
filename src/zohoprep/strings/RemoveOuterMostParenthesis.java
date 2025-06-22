package zohoprep.strings;

public class RemoveOuterMostParenthesis {
    public static void main(String[] args) {
        String s = "(()())";
        int counter = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (counter > 0) {
                    sb.append(ch);
                }
                counter++;
            } else {
                counter--;
                if (counter > 0) {
                    sb.append(ch);
                }
            }
        }
        System.out.println(sb.toString());

    }
}
