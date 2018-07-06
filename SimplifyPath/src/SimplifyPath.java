import java.util.Stack;

/**
 * Bibhas Abhishek
 * bibhas.abhishek@ril.com
 * 29 May 2018
 * https://leetcode.com/problems/simplify-path/description/
 **/
public class SimplifyPath {

    private static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int i = 0, len = path.length();
        while (i < len) {
            if (path.charAt(i) == '/') {
                int j = i + 1;
                while (j < len && path.charAt(j) != '/') {
                    j++;
                }

                String current = path.substring(i + 1, j);
                if (current.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    if (!current.equals(".") && !current.equals("")) {
                        stack.push(current);
                    }
                }
                i = j;
            }
        }

        for (String s : stack) {
            sb.append("/" + s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

}
