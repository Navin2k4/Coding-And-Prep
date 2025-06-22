public class DateAddManual {

    public static void main(String[] args) {
        String inputDate = "22-06-2025";
        int daysToAdd = 50;

        String resultDate = addDays(inputDate, daysToAdd);
        System.out.println("New date after adding " + daysToAdd + " days: " + resultDate);
    }

    static String addDays(String dateStr, int days) {
        // Parse date manually
        int day = Integer.parseInt(dateStr.substring(0, 2));
        int month = Integer.parseInt(dateStr.substring(3, 5));
        int year = Integer.parseInt(dateStr.substring(6, 10));

        // Days in each month
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Add days
        while (days > 0) {
            // Adjust for leap year
            monthDays[1] = isLeapYear(year) ? 29 : 28;

            int daysLeftInMonth = monthDays[month - 1] - day;

            if (days <= daysLeftInMonth) {
                day += days;
                days = 0;
            } else {
                days -= (daysLeftInMonth + 1);
                day = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
        }

        // Format final date
        return String.format("%02d-%02d-%04d", day, month, year);
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
