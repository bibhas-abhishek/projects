/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Jun 2018
 * https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=playlist&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-kit&slugs%5B%5D=strings
 * https://github.com/bibhas-abhishek/projects/tree/master/AlternatingCharacters
 **/

public class AlternatingCharacters {

    private static int alternatingCharacters(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABBB"));
    }

}
