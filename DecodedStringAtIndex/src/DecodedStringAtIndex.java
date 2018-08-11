/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Aug 2018
 * https://leetcode.com/problems/decoded-string-at-index/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/DecodedStringAtIndex
 */

public class DecodedStringAtIndex {

    /*private static String decodeAtIndex(String s, int k) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                encodedString.append(c);
            else {
                int n = Character.getNumericValue(c) - 1;
                String currentTape = encodedString.toString();
                while (n > 0) {
                    encodedString.append(currentTape);
                    n -= 1;
                }
            }
        }
        return String.valueOf(encodedString.charAt(k - 1));
    }*/

    private static String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size += 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size /= c - '0';
                k %= size;
            } else {
                if (k == 0 || k == size) {
                    return "" + c;
                }
                size--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(decodeAtIndex("leet2code3", 10));
    }

}
