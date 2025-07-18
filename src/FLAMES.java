class FLAMES {
    public static void main(String[] args) {
        int rounds = 0;
        String s1 = "navin";
        String s2 = "kumaran";
        int[] charfreq = new int[26];

        for (char ch : s1.toCharArray())
            charfreq[ch - 'a']++;

        for (char ch : s2.toCharArray())
            charfreq[ch - 'a']--;

        for (int num : charfreq)
            rounds += Math.abs(num);

        StringBuilder flames = new StringBuilder("FLAMES");
        int index = 0;

        while (flames.length() > 1) {
            index = (index + rounds - 1) % flames.length();
            System.out.println(flames.charAt(index));
            flames.deleteCharAt(index); 
        }

        System.out.println(getMeaning(flames.charAt(0)));

    }

    static String getMeaning(char c) {
        return switch (c) {
            case 'F' -> "Friends";
            case 'L' -> "Love";
            case 'A' -> "Affection";
            case 'M' -> "Marriage";
            case 'E' -> "Enemy";
            case 'S' -> "Siblings";
            default -> "Unknown";
        };
    }
}