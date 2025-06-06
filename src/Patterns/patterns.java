package Patterns;

public class patterns {

    static void Pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void Pattern2(int n) {
        // * Values of i learn
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
        // * Values of j learn
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
        // * Values of i*j learn
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
        System.out.println();
        // * Values of i+j learn
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i + j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void Pattern3(int n) {
        // Left Sided Pattern
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void Pattern4(int n) {
        // Reversed Left Sided Pattern
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void Pattern5(int n) {
        // Right sided pattern
        for (int i = 1; i <= n; i++) {
            // Print Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void Pattern6(int n) {
        // Reversed Right sided pattern
        for (int i = n; i >= 1; i--) {
            // Print Spaces
            for (int j = n - i; j >= 1; j--) {
                System.out.print("  ");
            }

            for (int k = i; k >= 1; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void Pattern7(int n) {
        // Pyramid Pattern
        for (int i = 1; i <= n; i++) {
            // Print Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void Pattern8(int n) {
        // Reverse pyramid pattern
        for (int i = n; i >= 1; i--) {
            // Print Spaces
            for (int j = n - i; j >= 1; j--) {
                System.out.print(" ");
            }

            for (int k = i; k >= 1; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void Pattern9(int n) {
        // Diamond Pattern
        for (int i = 1; i <= n; i++) {
            // Print Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            // Print Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // static void Pattern10(int n) {
    // }

    // static void Pattern11(int n) {
    // }

    // static void Pattern12(int n) {
    // }

    // static void Pattern13(int n) {
    // }

    // static void Pattern14(int n) {
    // }

    // static void Pattern15(int n) {
    // }

    public static void main(String[] args) {
        // Pattern1(5); // * Simple Square Pattern
        // Pattern2(5); // * Simple Square Number Patterns
        // Pattern3(5); // * Left Triangle Pattern
        // Pattern4(5); // * Reversed Left Triangle Pattern
        // Pattern5(5); // * Right Triangle Pattern
        // Pattern6(5); // * Reversed Right Triangle Pattern
        // Pattern7(5); // * Pyramid Pattern Bottom Up
        // Pattern8(5); // * Pyramid Pattern Top Down
        Pattern9(5); // * Diamond Pattern
    }
}