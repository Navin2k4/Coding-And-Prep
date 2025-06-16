package zohoprep.strings;


public class ValidateIPAddress {
    public static void main(String[] args) {
        System.out.println(isValid("222.111.111.111"));
        System.out.println(isValid("5555..555"));
        System.out.println(isValid("192.168.01.1"));
        System.out.println(isValid("0.0.0.255"));
    }

    // static boolean isValid(String s) {
    // /*
    // * 25[0-5] → 250 to 255
    // * 2[0-4][0-9] → 200 to 249
    // * 1[0-9]{2} → 100 to 199
    // * [1-9]?[0-9] → 0 to 99 (avoids leading zeros unless it's "0")
    // */
    // String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}"
    // + "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])$";
    // return s.matches(regex);
    // }

    static boolean isValid(String s) {
        String[] parts = s.split("\\.");

        // IP must have exactly 4 parts
        if (parts.length != 4)
            return false;

        for (String part : parts) {
            // Check for empty part
            if (part.isEmpty())
                return false;

            int num = Integer.parseInt(part);

            if (num < 0 || num > 255)
                return false;

            if (part.length() > 1 && part.startsWith("0"))
                return false;
        }

        return true;
    }
}
