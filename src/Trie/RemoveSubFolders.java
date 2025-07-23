package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFolders {
    public static void main(String[] args) {
        String folder[] = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        System.out.println(removeSubfolders(folder));
    }

    static List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder); 
            List<String> result = new ArrayList<>();

            for (String current : folder) {
                if (result.isEmpty() || !current.startsWith(result.get(result.size() - 1) + "/")) {
                    result.add(current);
                }
            }

            return result;
    }
}
