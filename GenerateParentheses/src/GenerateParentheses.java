import com.sun.tools.javah.Gen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 **/

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisUtil(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesisUtil(List<String> result, String str, int open, int closed, int count) {
        if (str.length() == 2 * count) {
            result.add(str);
            return;
        }

        if (open < count) {
            generateParenthesisUtil(result, str + "(", open + 1, closed, count);
        }

        if (closed < open) {
            generateParenthesisUtil(result, str + ")", open, closed + 1, count);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses driver = new GenerateParentheses();
        System.out.println(driver.generateParenthesis(3));
    }
}
