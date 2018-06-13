import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 13 Jun 2018
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/FirstUniqueCharInString
 **/

public class FirstUniqueCharInString {

    private static int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                map.put(c, i);
                set.add(c);
            } else
                map.remove(c);
        }
        return map.isEmpty() ? -1 : map.entrySet().iterator().next().getValue();
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

}
