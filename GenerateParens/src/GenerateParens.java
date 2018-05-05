import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 04 May 2018
 * https://leetcode.com/problems/generate-parentheses/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/GenerateParens
 **/

public class GenerateParens {

    private static List<String> generateParens(int count) {
        char[] array = new char[count * 2];
        List<String> result = new ArrayList<>();
        addParens(count, count, 0, array, result);
        return result;
    }

    private static void addParens(int leftRem, int rightRem, int index, char[] array, List<String> result) {
        if (leftRem == 0 && rightRem == 0) {
            result.add(new String(array));
            return;
        }

        if (leftRem > 0) {
            array[index] = '(';
            addParens(leftRem - 1, rightRem, index + 1, array, result);
        }

        if (rightRem > leftRem) {
            array[index] = ')';
            addParens(leftRem, rightRem - 1, index + 1, array, result);
        }
    }

    private static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    private static Set<String> generateParensAlt(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0)
            set.add("");
        else {
            Set<String> prev = generateParensAlt(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        System.out.println(generateParens(3));
        System.out.println(generateParensAlt(3));
    }

}
