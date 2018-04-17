/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    private static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
            builder.append(words[i]).append(" ");

        return builder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("   a   b   "));
    }

}
