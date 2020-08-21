import java.util.LinkedList;
import java.util.Queue;

public class MinStepsToReachTargetKnight {

    private boolean isValidMove(int x, int y, int n, boolean[][] visited) {
        return x >= 0 && x < n && y >= 0 && y < n && !visited[x][y];
    }

    public int minStepToReachTarget(int[] beginPos, int[] endPos, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { beginPos[0], beginPos[1], 0 });
        int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
        boolean[][] visited = new boolean[n][n];
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            visited[pos[0]][pos[1]] = true;
            if (pos[0] == endPos[0] && pos[1] == endPos[1]) {
                return pos[2];
            }

            for (int i = 0; i < 8; i++) {
                int newPosX = pos[0] + dx[i];
                int newPosY = pos[1] + dy[i];
                if (isValidMove(newPosX, newPosY, n, visited)) {
                    queue.offer(new int[] { newPosX, newPosY, pos[2] + 1 });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 8;
        int[] beginPos = { 0, 0 };
        int[] endPos = { 7, 7 };
        MinStepsToReachTargetKnight object = new MinStepsToReachTargetKnight();
        System.out.println(object.minStepToReachTarget(beginPos, endPos, N));
    }
}
