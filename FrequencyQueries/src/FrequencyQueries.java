import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Jun 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/FrequencyQueries
 **/

public class FrequencyQueries {

    private static int[] solve(int[][] queries) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
            int num = query[1];
            int k = map1.getOrDefault(num, 0);
            if (query[0] == 1) {
                if (k > 0)
                    map2.put(k, map2.get(k) - 1);
                map1.put(num, map1.getOrDefault(num, 0) + 1);
                map2.put(k + 1, map2.getOrDefault(k + 1, 0) + 1);
            } else if (query[0] == 2) {
                if (k > 0) {
                    map1.put(num, map1.getOrDefault(num, 0) - 1);
                    map2.put(k, map2.getOrDefault(k, 0) - 1);
                }
                if (k - 1 > 0)
                    map2.put(k - 1, map2.getOrDefault(k - 1, 0) + 1);
            } else
                list.add(map2.getOrDefault(num, 0) > 0 ? 1 : 0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int checkFreq(Map<Integer, Integer> map, int value) {
        for (Integer k : map.keySet()) {
            if (map.get(k) == value)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] queries = {{1, 1}, {2, 2}, {3, 2}, {1, 1}, {1, 1}, {2, 1}, {3, 2}};
        int[] result = solve(queries);
        Arrays.stream(result).mapToObj(a -> a + " ").forEach(System.out::print);
    }

}
