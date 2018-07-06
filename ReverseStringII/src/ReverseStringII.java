/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 13 Jun 2018
 * https://leetcode.com/problems/reverse-string-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ReverseStringII
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 **/

public class ReverseStringII {

    private static String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i += 2 * k) {
            int l = i;
            int r = Math.min(s.length() - 1, l + k - 1);
            while (l < r) {
                char temp = c[l];
                c[l++] = c[r];
                c[r--] = temp;
            }
        }
        return new String(c);
    }

    private static String reverseWords(String s) {
        StringBuilder word = new StringBuilder(), result = new StringBuilder();
        int i = 0;
        while (i <= s.length()) {
            if (i == s.length() || s.charAt(i) == ' ') {
                result.append(word.reverse());
                result.append(i == s.length() ? "" : " ");
                word = new StringBuilder();
            } else
                word.append(s.charAt(i));
            i += 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseWords("bibhas abhishek"));
    }

}
