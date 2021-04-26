import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {

    private int minStepToReachTarget(int[] beginPos, int[] endPos) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { beginPos[0], beginPos[1], 0 });
        int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            visited.add(beginPos[0] + "," + beginPos[1]);
            if (pos[0] == endPos[0] && pos[1] == endPos[1]) {
                return pos[2];
            }

            for (int i = 0; i < 8; i++) {
                int newPosX = pos[0] + dx[i];
                int newPosY = pos[1] + dy[i];
                if (!visited.contains(newPosX + "," + newPosY) && newPosX >= 0 && newPosY >= 0) {
                    queue.offer(new int[] { newPosX, newPosY, pos[2] + 1 });
                    visited.add(newPosX + "," + newPosY);
                }
            }
        }
        return -1;
    }

    public int minKnightMoves(int x, int y) {
        return minStepToReachTarget(new int[] { 0, 0 }, new int[] { Math.abs(x), Math.abs(y) });
    }

    public static void main(String[] args) {
        MinimumKnightMoves driver = new MinimumKnightMoves();
        System.out.println(driver.minKnightMoves(5, 5));
    }
}
