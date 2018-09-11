import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 10 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ReorganizeString
 */

public class ReorganizeString {

    private static String reorganizeString(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = hashMap.getOrDefault(c, 0) + 1;
            if (count > (s.length() + 1) / 2)
                return "";

            hashMap.put(c, count);
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : hashMap.keySet())
            pq.add(new int[]{c, hashMap.get(c)});       // [char, count]

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append((char) first[0]);
                if (--first[1] > 0)
                    pq.add(first);
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0)
                    pq.add(second);

                pq.add(first);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aabac"));
    }

}
