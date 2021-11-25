/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: MultiplyStrings
*- 18 Nov 2021 7:15 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/multiply-strings
-------------------------------------------*/

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        if (num1.equals("1")) {
            return num2;
        }

        if (num2.equals("1")) {
            return num1;
        }

        int m = num1.length();
        int n = num2.length();
        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product += result[i + j + 1];
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if (sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings driver = new MultiplyStrings();
        System.out.println(driver.multiply("12", "10"));
    }
}
