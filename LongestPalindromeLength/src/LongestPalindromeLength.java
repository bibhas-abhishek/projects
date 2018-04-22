import java.util.HashSet;
import java.util.Set;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 21 Apr 2018
 * https://leetcode.com/problems/longest-palindrome/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestPalindromeLength
 **/

public class LongestPalindromeLength {

    private static int longestPalindrome(String s) {
        Set<Character> hashSet = new HashSet<>();
        int palindromeLength = 0;
        for (char ch : s.toCharArray()) {
            if (!hashSet.contains(ch))
                hashSet.add(ch);
            else {
                palindromeLength += 1;
                hashSet.remove(ch);
            }
        }

        if (hashSet.size() == 0)
            return palindromeLength * 2;
        else
            return palindromeLength * 2 + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

}
