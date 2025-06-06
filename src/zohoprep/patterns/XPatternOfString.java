package zohoprep.patterns;

public class XPatternOfString {
    public static void main(String[] args) {
        String s = "PROGRAM";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    System.out.print(s.charAt(i) + " ");
                } else if (i + j == length - 1) {
                    System.out.print(s.charAt(j) + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
        
    }
    // P            M
    //   R        A
    //     O   R
    //       G
    //     O   R
    //   R        A
    // P            M
        

}  
