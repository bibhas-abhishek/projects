import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Aug 2018
 * https://leetcode.com/problems/water-and-jug-problem/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/WaterJugProblem
 */

public class WaterJugProblem {

    private static boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || z > x + y)
            return false;

        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n + x <= x + y && set.add(n + x))
                queue.offer(n + x);

            if (n + y <= x + y && set.add(n + y))
                queue.offer(n + y);

            if (n - x >= 0 && set.add(n - x))
                queue.offer(n - x);

            if (n - y >= 0 && set.add(n - y))
                queue.offer(n - y);

            if (set.contains(z))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canMeasureWater(3, 5, 4));
    }

}
