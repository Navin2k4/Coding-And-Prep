package zohoprep.strings;

class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));
        System.out.println(isPalindrome("tab a cat"));
    }
    static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left <= right) {
        char chLeft = s.charAt(left);
        char chRight = s.charAt(right);

        // Skip non-alphanumeric from left
        if (!Character.isLetterOrDigit(chLeft)) {
            left++;
            continue;
        }

        // Skip non-alphanumeric from right
        if (!Character.isLetterOrDigit(chRight)) {
            right--;
            continue;
        }

        // Compare lowercase versions
        if (Character.toLowerCase(chLeft) != Character.toLowerCase(chRight)) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}

}