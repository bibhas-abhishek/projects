import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0)
            anagramCount(in.next());
    }

    private static void anagramCount(String s) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                String sortedSubstring = sortString(subString);
                if (!hashMap.containsKey(sortedSubstring))
                    hashMap.put(sortedSubstring, 1);
                else
                    hashMap.put(sortedSubstring, hashMap.get(sortedSubstring) + 1);
            }
        }

        int twiceAnagramCount = 0;
        for (String key : hashMap.keySet()) {
            int value = hashMap.get(key);
            twiceAnagramCount += value * (value - 1) / 2;
        }
        System.out.println(twiceAnagramCount);
    }

    private static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
