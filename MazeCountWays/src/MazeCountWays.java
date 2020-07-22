/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Sep 2018
 * https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
 */

public class MazeCountWays {

    public int countPaths(int[][] maze) {
        // -1 nodes in the maze are blocked
        int r = maze.length - 1, c = maze[0].length - 1;
        if (maze[0][0] == -1 || maze[r][c] == -1) {
            return 0;
        }

        for (int i = 0; i <= c; i++) {
            if (maze[0][i] == 0) {
                maze[0][i] = 1;
            }
            else
                break;
        }

        for (int j = 0; j <= r; j++) {
            if (maze[j][0] == 0) {
                maze[j][0] = 1;
            }
            else
                break;
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (maze[i][j] == -1) {
                    continue;
                }

                if (maze[i - 1][j] > 0) {
                    maze[i][j] += maze[i - 1][j];
                }

                if (maze[i][j - 1] > 0) {
                    maze[i][j] += maze[i][j - 1];
                }
            }
        }
        return maze[r][c];
    }

    public static void main(String[] args) {
        int[][] maze = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
        System.out.println(new MazeCountWays().countPaths(maze));
    }
}
