/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 20 Apr 2018
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ReverseVowelsofaString
 **/

public class ReverseVowelsofaString {

    private static String reverseVowels(String s) {
        String vowels = "AEIOUaeiou";
        char[] strArr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {

            // skip until i is a vowel
            while ((i < j) && vowels.indexOf(strArr[i]) == -1)
                i += 1;

            //skip until j is a vowel
            while ((i < j) && vowels.indexOf(strArr[j]) == -1)
                j -= 1;

            if (i > j)
                break;

            swap(strArr, i, j);
            i += 1;
            j -= 1;
        }
        return new String(strArr);
    }

    private static void swap(char[] strArr, int i, int j) {
        char ch = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = ch;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

}
