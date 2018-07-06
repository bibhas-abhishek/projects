import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Jun 2018
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?filter=java&filter_on=language&h_l=playlist&h_r=next-challenge&h_v=zen&limit=100&page=2&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-kit&slugs%5B%5D=strings
 * https://github.com/bibhas-abhishek/projects/tree/master/SherlockandtheValidString
 **/

public class SherlockandtheValidString {

    static String isValid(String s) {
        int[] array = new int[26];
        for (char c : s.toCharArray())
            array[c - 'a'] += 1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (i == 0)
                continue;

            map.compute(i, (key, value) -> {
                if (value == null)
                    return 1;
                else
                    return value + 1;
            });
        }

        if (map.size() == 1 || map.size() == 2 && isValidCount(map))
            return "YES";
        return "NO";
    }

    private static boolean isValidCount(Map<Integer, Integer> map) {
        int[] keys = new int[map.size()];
        int index = 0;
        for (int k : map.keySet()) {
            keys[index] = k;
            index += 1;
        }

        for (int i = 0; i < keys.length; i++) {
            if (map.get(keys[i]) == 1) {
                int j = i == map.size() - 1 ? 0 : map.size() - 1;
                if (keys[i] == 1 || keys[i] - keys[j] == 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aaabbbccccc"));
    }

}
