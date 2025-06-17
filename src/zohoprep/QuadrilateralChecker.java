package zohoprep;

import java.util.Arrays;

public class QuadrilateralChecker {
    public static void main(String[] args) {
        int[] p1 = { 0, 0 };
        int[] p2 = { 0, 2 };
        int[] p3 = { 3, 2 };
        int[] p4 = { 3, 0 };

        String result = checkShape(p1, p2, p3, p4);
        System.out.println("Shape: " + result);
    }

    static String checkShape(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[] d = new int[] {
                distance(p1, p2),
                distance(p1, p3),
                distance(p1, p4),
                distance(p2, p3),
                distance(p2, p4),
                distance(p3, p4)
        };

        Arrays.sort(d);

        System.out.println(Arrays.toString(d));

        if (d[0] > 0 &&
                d[0] == d[1] && d[1] == d[2] && d[2] == d[3] &&
                d[4] == d[5])
            return "Square";

        if (d[0] > 0 &&
                d[0] == d[1] && d[2] == d[3] &&
                d[0] != d[2] &&
                d[4] == d[5])
            return "Rectangle";

        return "Other Shape";
    }

    static int distance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}
