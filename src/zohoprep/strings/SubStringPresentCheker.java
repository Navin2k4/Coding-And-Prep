package zohoprep.strings;

public class SubStringPresentCheker {
    public static void main(String[] args) {
        String s1 = "test123string";
        String s2 = "123";
        // output = 4; index of 1 is 4;
        System.out.println(returnStartIndex(s1, s2));
    }

    static int returnStartIndex(String s1, String s2) {
        int tLength = s1.length();
        int sLength = s2.length();
        int traversalLength = tLength - sLength;
        if (tLength < sLength)
            return -1;
        for (int i = 0; i <= traversalLength; i++) {
            boolean found = true;
            for (int j = 0; j < sLength; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    found = false;
                    break;
                }
                if (found) {
                    return i;
                }
            }
        }

        return -1;
    }
}
