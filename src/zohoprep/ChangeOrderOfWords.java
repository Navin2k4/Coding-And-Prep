package zohoprep;

public class ChangeOrderOfWords {
    public static void main(String[] args) {
        String input = "one two three";
        String[] words = input.split(" ");

        String result = reverseWords(words, 0).trim();
        System.out.println(result);
    }

    static String reverseWords(String[] words, int index) {
        if(index == words.length){
            return "";
        }
        String rest = reverseWords(words, index+1);

        return rest + (rest.isEmpty() ? "" : " ") + words[index];
    }

}
