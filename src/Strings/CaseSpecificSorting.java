package Strings;

import java.util.ArrayList;
import java.util.Collections;

class CasespecificSorting {
    public static void main(String[] args) {
        String s = "GEekS";
        System.out.println(sort(s));
    }

    static String sort(String s) {
        ArrayList<Character> upc = new ArrayList<>();
        ArrayList<Character> lwc = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upc.add(s.charAt(i));
            } else {
                lwc.add(s.charAt(i));
            }
        }

        Collections.sort(upc);
        Collections.sort(lwc);
        Collections.reverse(upc);
        Collections.reverse(lwc);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                res.append(upc.remove(upc.size() - 1));  
            } else {
                res.append(lwc.remove(lwc.size() - 1));  
            }
        }

        return res.toString();
    }
}