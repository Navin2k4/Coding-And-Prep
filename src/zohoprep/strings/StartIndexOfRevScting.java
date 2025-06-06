package zohoprep.strings;

public class StartIndexOfRevScting {
    public static void main(String[] args) {
        String s1 = "I came by car";
        String s2 = "emac";
        System.out.println(findStartIndex(s1, s2));
        String s3 = "I play tennis";
        String s4 = "tennis";
        System.out.println(findStartIndex(s3, s4));
    }

    static int findStartIndex(String s, String t) {
        String reversedT = new StringBuilder(t).reverse().toString();
        int sLen = s.length();
        int tLen = reversedT.length();

        // Fix: wrong comparison
        if (tLen > sLen)
            return -1;

        int range = sLen - tLen;

        for (int i = 0; i <= range; i++) {
            boolean found = true;
            for (int j = 0; j < tLen; j++) {
                if (s.charAt(i + j) != reversedT.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found)
                return i;
        }

        return -1;
    }

    // ! There is Something called KMP algorithm try to learn them in future

}
