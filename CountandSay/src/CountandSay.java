/**
 * https://leetcode.com/problems/count-and-say/description/
 */

public class CountandSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    private static String countAndSay(int n) {
        String[] sequence = new String[n];
        sequence[0] = "1";
        if (n == 1)
            return sequence[n - 1];

        sequence[1] = "11";
        for (int i = 2; i < n; i++) {
            String input = sequence[i - 1];
            StringBuilder builder = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= input.length(); j++) {
                if (j == input.length() || input.charAt(j) != input.charAt(j - 1)) {
                    builder.append(count).append(input.charAt(j - 1));
                    count = 1;
                } else
                    count += 1;
            }
            sequence[i] = builder.toString();
        }
        return sequence[n - 1];
    }

}
