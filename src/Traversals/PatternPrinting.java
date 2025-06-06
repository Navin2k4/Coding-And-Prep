package Traversals;
import java.util.Scanner;
// Square Pattern	Basic N x N square of *
// Right-Angled Triangle	Triangle increasing left to right
// Inverted Right Triangle	Triangle decreasing left to right
// Full Pyramid	Symmetric pyramid with *
// Inverted Pyramid	Upside-down pyramid
// Diamond Pattern	Full pyramid + Inverted pyramid
// Hollow Square	Square with only borders
// Hollow Pyramid	Pyramid with empty center
// Butterfly Pattern	Two mirrored right-angle triangles
// Pascal's Triangle	Famous Pascal’s triangle (binomial coefficients)
// Floyd’s Triangle	Number sequence triangle
// Hollow Diamond	Diamond with empty center
// X Pattern	X shape using *
// Hourglass / Sandglass	Inverted pyramid on top of a normal pyramid
// Spiral Matrix	Numbers spiraling inwards
// Number Pyramid	Increasing numbers in pyramid shape
// Hollow Triangle	Triangle with empty middle
// Alphabet Pyramid	Pyramid with increasing letters

public class PatternPrinting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size (N) for patterns: ");
        int n = sc.nextInt();

        System.out.println("\n1. Square Pattern");
        squarePattern(n);

        System.out.println("\n2. Right-Angled Triangle");
        rightAngledTriangle(n);

        System.out.println("\n3. Inverted Right-Angled Triangle");
        invertedRightAngledTriangle(n);

        System.out.println("\n4. Full Pyramid");
        fullPyramid(n);

        System.out.println("\n5. Inverted Pyramid");
        invertedPyramid(n);

        System.out.println("\n6. Diamond Pattern");
        diamondPattern(n);

        System.out.println("\n7. Hollow Square");
        hollowSquare(n);

        System.out.println("\n8. Hollow Pyramid");
        hollowPyramid(n);

        System.out.println("\n9. Butterfly Pattern");
        butterflyPattern(n);

        System.out.println("\n10. Pascal's Triangle");
        pascalsTriangle(n);

        System.out.println("\n1. Floyd’s Triangle");
        floydsTriangle(n);

        System.out.println("\n2. Hollow Diamond");
        hollowDiamond(n);

        System.out.println("\n3. X Pattern");
        xPattern(n);

        System.out.println("\n4. Hourglass / Sandglass");
        sandglassPattern(n);

        System.out.println("\n5. Spiral Matrix");
        spiralMatrix(n);

        System.out.println("\n6. Number Pyramid");
        numberPyramid(n);

        System.out.println("\n7. Hollow Triangle");
        hollowTriangle(n);

        System.out.println("\n8. Alphabet Pyramid");
        alphabetPyramid(n);

        System.out.println("\n1. Plus Pattern");
        plusPattern(n);

        System.out.println("\n2. Cross Pattern");
        crossPattern(n);

        System.out.println("\n3. Arrow Pattern");
        arrowPattern(n);

        System.out.println("\n4. Hollow Rhombus");
        hollowRhombus(n);

        System.out.println("\n5. Checkerboard Pattern");
        checkerboard(n);

        System.out.println("\n6. Hollow Hexagon");
        hollowHexagon(n);

        System.out.println("\n7. Filled Hexagon");
        filledHexagon(n);

        System.out.println("\n8. Zig-Zag Wave");
        zigzagWave(n);

        System.out.println("\n9. Star Box Pattern");
        starBox(n);

        System.out.println("\n10. Triangular Snail Pattern");
        triangularSnail(n);

        System.out.println("\n11. Rectangular Spiral");
        rectangularSpiral(n);

        System.out.println("\n12. Pine Tree Pattern");
        pineTree(n);

        System.out.println("\n13. Christmas Tree");
        christmasTree(n);

        System.out.println("\n14. Concentric Circles (Approximate)");
        concentricCircles(n);

        sc.close();
    }

    // 1. Square Pattern
    static void squarePattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 2. Right-Angled Triangle
    static void rightAngledTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 3. Inverted Right-Angled Triangle
    static void invertedRightAngledTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 4. Full Pyramid
    static void fullPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 5. Inverted Pyramid
    static void invertedPyramid(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 6. Diamond Pattern
    static void diamondPattern(int n) {
        fullPyramid(n);
        invertedPyramid(n - 1);
    }

    // 7. Hollow Square
    static void hollowSquare(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    // 8. Hollow Pyramid
    static void hollowPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == n)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    // 9. Butterfly Pattern
    static void butterflyPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            for (int j = 1; j <= 2 * (n - i); j++) System.out.print("  ");
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            for (int j = 1; j <= 2 * (n - i); j++) System.out.print("  ");
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 10. Pascal's Triangle
    static void pascalsTriangle(int n) {
        for (int line = 1; line <= n; line++) {
            int num = 1;
            for (int j = 1; j <= n - line; j++)
                System.out.print("  ");
            for (int j = 1; j <= line; j++) {
                System.out.print(num + "   ");
                num = num * (line - j) / j;
            }
            System.out.println();
        }
    }

    // 1. Floyd’s Triangle
    static void floydsTriangle(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    // 2. Hollow Diamond
    static void hollowDiamond(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                if (j == 1 || j == 2 * i - 1) System.out.print("*");
                else System.out.print(" ");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++)
                if (j == 1 || j == 2 * i - 1) System.out.print("*");
                else System.out.print(" ");
            System.out.println();
        }
    }

    // 3. X Pattern
    static void xPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    // 4. Hourglass / Sandglass Pattern
    static void sandglassPattern(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            for (int j = 0; j < i; j++) System.out.print("* ");
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            for (int j = 0; j < i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 5. Spiral Matrix
    static void spiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int val = 1, top = 0, left = 0, bottom = n - 1, right = n - 1;
        while (val <= n * n) {
            for (int i = left; i <= right; i++) matrix[top][i] = val++;
            top++;
            for (int i = top; i <= bottom; i++) matrix[i][right] = val++;
            right--;
            for (int i = right; i >= left; i--) matrix[bottom][i] = val++;
            bottom--;
            for (int i = bottom; i >= top; i--) matrix[i][left] = val++;
            left++;
        }
        for (int[] row : matrix) {
            for (int num : row) System.out.printf("%3d", num);
            System.out.println();
        }
    }

    // 6. Number Pyramid
    static void numberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            System.out.println();
        }
    }

    // 7. Hollow Triangle
    static void hollowTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == n) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    // 8. Alphabet Pyramid
    static void alphabetPyramid(int n) {
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print(ch);
            ch++;
            System.out.println();
        }
    }

    static void plusPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n / 2 || j == n / 2) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    // 2. Cross Pattern
    static void crossPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    // 3. Arrow Pattern
    static void arrowPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 4. Hollow Rhombus
    static void hollowRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= n; j++)
                if (i == 1 || i == n || j == 1 || j == n) System.out.print("*");
                else System.out.print(" ");
            System.out.println();
        }
    }

    // 5. Checkerboard
    static void checkerboard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(((i + j) % 2 == 0) ? "* " : "  ");
            System.out.println();
        }
    }

    // 6. Hollow Hexagon
    static void hollowHexagon(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < Math.abs(n - i - 1); j++) System.out.print(" ");
            for (int j = 0; j < n; j++)
                if (i == 0 || i == 2 * n - 2 || j == 0 || j == n - 1) System.out.print("* ");
                else System.out.print("  ");
            System.out.println();
        }
    }

    // 7. Filled Hexagon
    static void filledHexagon(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < Math.abs(n - i - 1); j++) System.out.print(" ");
            for (int j = 0; j < n; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 8. Zig-Zag Wave
    static void zigzagWave(int n) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i + j) % 4 == 0 || (i == 2 && j % 4 == 0)) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    // 9. Star Box
    static void starBox(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 10. Triangular Snail
    static void triangularSnail(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(num++ + " ");
            System.out.println();
        }
    }

    // 11. Rectangular Spiral
    static void rectangularSpiral(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                if (i == 1 || j == 1 || i == n || j == n) System.out.print("* ");
                else System.out.print("  ");
            System.out.println();
        }
    }

    // 12. Pine Tree
    static void pineTree(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) System.out.print(" ");
            for (int j = 0; j < 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 13. Christmas Tree
    static void christmasTree(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < n / 2; i++) System.out.println("  ***  ");
    }

    // 14. Concentric Circles (Approximate)
    static void concentricCircles(int n) {
        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++)
                System.out.print((i * i + j * j <= n * n) ? "* " : "  ");
            System.out.println();
        }
    }

}
