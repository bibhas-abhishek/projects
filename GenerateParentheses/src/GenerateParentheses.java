/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: GenerateParentheses
*- 06 Nov 2021 1:01 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesis(List<String> result, String str, int open, int closed,
                                     int count) {
        if (str.length() == 2 * count) {
            result.add(str);
            return;
        }

        if (open < count) {
            generateParenthesis(result, str + "(", open + 1, closed, count);
        }

        if (closed < open) {
            generateParenthesis(result, str + ")", open, closed + 1, count);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses driver = new GenerateParentheses();
        System.out.println(driver.generateParenthesis(3));
    }
}
