import java.util.HashSet;
import java.util.Set;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 18 Jun 2018
 * https://leetcode.com/problems/unique-morse-code-words/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/UniqueMorseCodeWords
 **/

public class UniqueMorseCodeWords {

    private static int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> result = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray())
                builder.append(morse[c - 'a']);
            result.add(builder.toString());
        }
        return result.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

}
