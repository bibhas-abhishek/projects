import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 25 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/EggDropping
 **/

public class EggDropping {

    private static Map<String, Integer> map = new HashMap<>();

    /**
     * @param n -> eggs
     * @param k -> floors
     * @return
     */
    private static int eggDrop(int n, int k) {
        if (k == 0 || k == 1)
            return k;

        if (n == 1)
            return k;

        String key = n + "-" + k;

        if (map.containsKey(key))
            return map.get(key);

        int result = Integer.MAX_VALUE;
        for (int floor = 1; floor <= k; floor++) {
            int drops = Math.max(eggDrop(n - 1, floor - 1), eggDrop(n, k - floor));
            result = Math.min(result, drops);
        }
        map.put(key, result + 1);
        return result + 1;
    }

    public static void main(String[] args) {
        System.out.println(eggDrop(2, 36));
    }

}
