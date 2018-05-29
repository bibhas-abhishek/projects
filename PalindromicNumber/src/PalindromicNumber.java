/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 27 May 2018
 * https://leetcode.com/problems/palindrome-number/
 * https://github.com/bibhas-abhishek/projects/tree/master/PalindromicNumber
 **/

public class PalindromicNumber {

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == x || reverse / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

}
