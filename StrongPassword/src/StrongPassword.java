/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Mar 2018
 * https://www.hackerrank.com/challenges/strong-password/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/StrongPassword
 **/

public class StrongPassword {

    private static String numbers = "0123456789";
    private static String lowerSase = "abcdefghijklmnopqrstuvwxyz";
    private static String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String specialCharacters = "!@#$%^&*()-+";

    public static void main(String[] args) {
        System.out.print(minimumNumber(11, "#HackerRank"));
    }

    private static int minimumNumber(int n, String password) {
        boolean noDigit = true, noLower = true, noUpper = true, noSpecial = true;
        int misses = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (numbers.indexOf(c) != -1)
                noDigit = false;
            if (lowerSase.indexOf(c) != -1)
                noLower = false;
            if (upperCase.indexOf(c) != -1)
                noUpper = false;
            if (specialCharacters.indexOf(c) != -1)
                noSpecial = false;
        }
        if (noDigit)
            misses++;
        if (noLower)
            misses++;
        if (noUpper)
            misses++;
        if (noSpecial)
            misses++;
        return Math.max(6 - n, misses);
    }

}
