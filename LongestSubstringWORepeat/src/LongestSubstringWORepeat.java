/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: AddLinkedLists1
*- 23 Nov 2021 7:14 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/longest-substring-without-repeating-characters
-------------------------------------------*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWORepeat {

    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isUniqueString(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    private static boolean isUniqueString(String s, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = i; k <= j; k++) {
            if (set.contains(s.charAt(k))) {
                return false;
            }
            set.add(s.charAt(k));
        }
        return true;
    }

    private static int lengthOfLongestSubstringOptimised(String s) {
        int i, j;
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (i = 0, j = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstringOptimised("abccabdef"));
    }
}
