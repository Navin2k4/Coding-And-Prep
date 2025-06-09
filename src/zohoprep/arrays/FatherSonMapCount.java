package zohoprep.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FatherSonMapCount {
    public static void main(String[] args) {
        String[][] familyTree = {
                { "luke", "shaw" },
                { "wayne", "rooney" },
                { "rooney", "ronaldo" },
                { "shaw", "rooney" }
        };
        HashMap<String, List<String>> familyMap = new HashMap<>();

        for (int i = 0; i < familyTree.length; i++) {
            String child = familyTree[i][0];
            String father = familyTree[i][1];
            // familyMap.computeIfAbsent(father, k -> new ArrayList<>()).add(child);
            if (!familyMap.containsKey(father)) {
                familyMap.put(father, new ArrayList<>());
            }
            familyMap.get(father).add(child);
        }

        System.out.println("Grandchildren of ronaldo: " + getNoOfGrandChildrens(familyMap, "ronaldo"));
    }

    static int getNoOfGrandChildrens(HashMap<String, List<String>> familyMap, String grandFather) {
        int count = 0;

        List<String> children = familyMap.getOrDefault(grandFather, new ArrayList<>());

        for (String child : children) {
            List<String> grandChildren = familyMap.getOrDefault(child, new ArrayList<>());
            count += grandChildren.size();
        }

        return count;
    }
}
