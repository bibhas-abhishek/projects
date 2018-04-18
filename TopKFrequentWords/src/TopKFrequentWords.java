import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 18 Apr 2018
 * https://leetcode.com/problems/top-k-frequent-words/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/TopKFrequentWords
 **/

public class TopKFrequentWords {

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String word : words)
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);

        List<String> result = new ArrayList<>(hashMap.keySet());
        result.sort((w1, w2) -> hashMap.get(w1) == hashMap.get(w2) ?
                w1.compareTo(w2) : hashMap.get(w2).compareTo(hashMap.get(w1)));
        return result.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words, 2));
    }

}
