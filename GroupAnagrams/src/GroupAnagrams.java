import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Dec 2017
 * https://leetcode.com/problems/group-anagrams/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/GroupAnagrams/
 **/

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] stringArray = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print(groupAnagrams(stringArray));
    }

    private static List<List<String>> groupAnagrams(String[] stringArray) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : stringArray) {
            String key = sortString(str);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<>());
            }

            List<String> mapValue = hashMap.get(key);
            mapValue.add(str);
            hashMap.put(key, mapValue);
        }

        List<List<String>> mapList = new ArrayList<>();
        for (String key : hashMap.keySet())
            mapList.add(hashMap.get(key));

        return mapList;
    }

    private static String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

}
