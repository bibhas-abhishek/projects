import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 15 Sep 2018
 * https://leetcode.com/problems/minimum-window-substring/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MinimumWindowSubstring
 */

public class MinimumWindowSubstring {

    private static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // map which keeps a count of all the unique characters in t
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dict.getOrDefault(t.charAt(i), 0);
            dict.put(t.charAt(i), count + 1);
        }

        // number of unique characters in t which need to be present in the desired window
        int required = dict.size();

        // left and right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency
        // e.g. if t is "AABC" then the window must have two A's, one B and one C
        // thus formed would be = 3 when all these conditions are met
        int formed = 0;

        // map which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // if the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1
            if (dict.containsKey(c) && windowCounts.get(c) == dict.get(c)) {
                formed += 1;
            }

            // try and contract the window till the point where it ceases to be desirable
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // save the smallest window until now
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // the character at the position pointed by the left pointer is no longer a part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dict.containsKey(c) && windowCounts.get(c) < dict.get(c)) {
                    formed -= 1;
                }

                // move the left pointer ahead
                // this would help to look for a new window
                l += 1;
            }

            // keep expanding the window once we are done contracting
            r += 1;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

}
