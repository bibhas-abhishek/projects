import java.util.Arrays;

// https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/

public class LongestSubstringKUnique {

    private final static int MAX_CHARS = 26;

    // check if number of unique characters exceed k
    private boolean isValidWindow(int[] freq, int k) {
        int c = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                c += 1;
            }
        }
        return c <= k;
    }

    @SuppressWarnings("DuplicateExpressions")
    public void longestSubstringKUniqueUtil(String s, int k) {
        int[] freq = new int[MAX_CHARS];
        Arrays.fill(freq, 0);
        int uniqueChars = 0;

        // check if string contains >=k unique characters
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 0) {
                uniqueChars += 1;
            }
            freq[s.charAt(i) - 'a'] += 1;
        }

        if (uniqueChars < k) {
            System.out.println("ERROR: k unique chars do not exist");
            return;
        }

        Arrays.fill(freq, 0);
        int wStart = 0, wSize = 1, start = 0, end = 0;
        freq[s.charAt(0) - 'a'] += 1;
        for (int i = 1; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
            end += 1;

            if (!isValidWindow(freq, k)) {
                freq[s.charAt(start) - 'a'] -= 1;
                start += 1;
            }

            if (end - start + 1 > wSize) {
                wSize = end - start + 1;
                wStart = start;
            }
        }
        System.out.println("Max substring is: " + s.substring(wStart, wStart + wSize) + "; length: " + wSize);
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        new LongestSubstringKUnique().longestSubstringKUniqueUtil(s, k);
    }
}
