import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 29 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LetterCombinationsPhoneNumber
 **/

public class LetterCombinationsPhoneNumber {


    private static List<String> letterCombinations(String digits) {
        String mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;

        result.add("");
        for (int i = 0; i < digits.length(); i++)
            result = solve(mapping[digits.charAt(i) - '0'], result);
        return result;
    }

    private static List<String> solve(String s, List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (String k : list)
                result.add(s.charAt(i) + k);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
