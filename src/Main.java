import java.util.Set;

public class Main {
    static Set<String> dictionary;
    public static void main(String[] args) {
	    dictionary = new FileHandler().getValidWords();
        System.out.println(decodingMessage("LAGUNE"));
    }
    public static boolean isValid(String word) {
        return dictionary.contains(word);
    }
    public static String decodingMessage(String input) {
        int size = input.length();
        if (size == 0) {
            return "";
        }
        for (int i = size - 1; i >= 0 ; i--) {
            String word = input.substring(i, size);
            if (isValid(word)) {
                String decodedMessage = decodingMessage(input.substring(0,i));
                if (decodedMessage != null) {
                    return decodedMessage + " " + word;
                }
            }
        }

        return null;
    }
}
