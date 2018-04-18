import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 18 Apr 2018
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SortCharactersByFrequency
 **/

public class SortCharactersByFrequency {

    private static String frequencySort(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char ch : s.toCharArray())
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);

        Queue<Character> maxHeap = new PriorityQueue<>(((c1, c2) -> hashMap.get(c2).compareTo(hashMap.get(c1))));
        for (char ch : hashMap.keySet())
            maxHeap.offer(ch);

        StringBuilder builder = new StringBuilder();
        while (maxHeap.size() > 0) {
            char ch = maxHeap.poll();
            int k = hashMap.get(ch);
            while (k-- > 0)
                builder.append(ch);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }

}
