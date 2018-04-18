import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 18 Apr 2018
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/TopKFrequentElements
 **/

public class TopKFrequentElements {

    private static List<Integer> topKFrequent(int[] array, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int key : array)
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);

        Queue<Integer> maxHeap = new PriorityQueue<>((w1, w2) -> hashMap.get(w2).compareTo(hashMap.get(w1)));
        for (Integer key : hashMap.keySet())
            maxHeap.add(key);

        while (k-- > 0 && maxHeap.size() > 0)
            result.add(maxHeap.poll());

        return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 0, 1, 0};
        System.out.println(topKFrequent(array, 1));
    }

}
