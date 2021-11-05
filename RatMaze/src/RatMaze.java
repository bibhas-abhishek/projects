public class RatMaze {

    // '0' in maze matrix is blocked
    private boolean isSafe(int[][] maze, int x, int y) {
        int n = maze.length;
        return x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1;
    }

    private boolean solveMaze(int[][] maze, int x, int y, int[][] result, int n) {
        if (x == n - 1 && y == n - 1) {
            result[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            result[x][y] = 1;
            if (solveMaze(maze, x, y + 1, result, n) || solveMaze(maze, x + 1, y, result, n)) {
                return true;
            }
            result[x][y] = 0;
            return false;
        }
        return false;
    }

    public void solveMaze(int[][] maze, int[][] result) {
        int n = maze.length;
        solveMaze(maze, 0, 0, result, n);
    }

    public void printResult(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RatMaze driver = new RatMaze();
        int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
        int[][] result = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        driver.solveMaze(maze, result);
        driver.printResult(result);
    }
}
