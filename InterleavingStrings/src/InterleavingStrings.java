/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: InterleavingStrings
*- 06 Nov 2021 12:56 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {

    public boolean findSI(String m, String n, String p) {
        Map<String, Boolean> dp = new HashMap<>();
        return findSI(dp, m, n, p, 0, 0, 0);
    }

    private boolean findSI(Map<String, Boolean> dp, String m, String n, String p, int i, int j,
                           int k) {
        if (i == m.length() && j == n.length() && k == p.length()) {
            return true;
        }

        if (k == p.length()) {
            return false;
        }

        String key = i + "-" + j + "-" + k;
        boolean b1 = false, b2 = false;
        if (dp.get(key) == null) {
            if (i < m.length() && m.charAt(i) == p.charAt(k)) {
                b1 = findSI(dp, m, n, p, i + 1, j, k + 1);
            }

            if (j < n.length() && n.charAt(j) == p.charAt(k)) {
                b2 = findSI(dp, m, n, p, i, j + 1, k + 1);
            }
            dp.put(key, b1 || b2);
        }
        return dp.get(key);
    }

    public static void main(String[] args) {
        InterleavingStrings driver = new InterleavingStrings();
        System.out.println(driver.findSI("abd", "cef", "abcdef"));
        System.out.println(driver.findSI("abd", "cef", "adcbef"));
        System.out.println(driver.findSI("abc", "def", "abdccf"));
        System.out.println(driver.findSI("abcdef", "mnop", "mnaobcdepf"));
    }
}
