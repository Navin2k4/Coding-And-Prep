
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
/**
 *
 * @author Asus
 */
public class OccuranceString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String input = sc.nextLine();
        System.out.println(generateString(input));
        sc.close();
    }

    static String generateString(String str) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            res.append(entry.getKey());
            res.append(entry.getValue());
        }
        return res.toString();
    }
}
