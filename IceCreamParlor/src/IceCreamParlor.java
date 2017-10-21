import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 21 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/IceCreamParlor
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++)
                cost[i] = in.nextInt();

            int[] result = solve(cost, m);
            for (int i = 0; i < result.length; i++)
                System.out.println(result[i] + " ");
        }
    }

    private static int[] solve(int[] cost, int m) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            int diff = m - cost[i];
            if (hashMap.containsKey(diff))
                return new int[]{hashMap.get(diff) + 1, i + 1};
            hashMap.put(cost[i], i);
        }
        return new int[]{-1, -1};
    }

}
