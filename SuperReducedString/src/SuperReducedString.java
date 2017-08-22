import java.util.Scanner;

public class SuperReducedString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = FooBar(s);
        System.out.println(result);
    }

    private static String FooBar(String s) {
        StringBuilder builder = new StringBuilder();
        boolean changed = false;
        int i = 0;
        while (i < s.length()) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1))
                builder.append(s.charAt(i++));
            else {
                i += 2;
                changed = true;
            }
        }
        if (!changed)
            return builder.toString();
        else
            return builder.length() == 0 ? "Empty String" : FooBar(builder.toString());
    }
}
