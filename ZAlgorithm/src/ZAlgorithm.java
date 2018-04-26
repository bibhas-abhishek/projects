import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 25 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ZAlgorithm
 **/

public class ZAlgorithm {

    private static List<Integer> matchPattern(char[] text, char[] pattern) {
        char[] concat = new char[1 + text.length + pattern.length];
        int i = 0;
        for (char ch : pattern)
            concat[i++] = ch;

        concat[i++] = '$';
        for (char ch : text)
            concat[i++] = ch;

        List<Integer> result = new ArrayList<>();
        int[] zString = calculateZ(concat);
        for (i = 0; i < zString.length; i++) {
            if (zString[i] == pattern.length)
                result.add(i - pattern.length - 1);
        }
        return result;
    }

    private static int[] calculateZ(char[] zString) {
        int z[] = new int[zString.length];
        int left = 0, right = 0;
        for (int k = 1; k < zString.length; k++) {
            if (k > right) {
                left = right = k;
                while (right < zString.length && zString[right] == zString[right - left])
                    right += 1;

                z[k] = right - left;
                right -= 1;
            } else {
                int boxIndex = k - left;
                if (z[boxIndex] < right - k + 1) {
                    z[k] = z[boxIndex];
                } else {
                    left = k;
                    while (right < zString.length && zString[right] == zString[right - left])
                        right += 1;

                    z[k] = right - left;
                    right -= 1;
                }
            }
        }
        return z;
    }

    public static void main(String[] args) {
        String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
        String pattern = "aaabc";
        List<Integer> result = matchPattern(text.toCharArray(), pattern.toCharArray());
        result.forEach(System.out::println);
    }

}
