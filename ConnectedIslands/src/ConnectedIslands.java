/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 04 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ConnectedIslands
 */

public class ConnectedIslands {

    private boolean isSafe(int x, int y, int[][] water, boolean[][] visited) {
        int row = water.length;
        int col = water[0].length;
        return x >= 0 && x < row && y >= 0 && y < col && water[x][y] == 1 && !visited[x][y];
    }

    private void dfs(int x, int y, int[][] water, boolean[][] visited) {
        visited[x][y] = true;
        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                int nextX = x + row;
                int nextY = y + col;
                if (isSafe(nextX, nextY, water, visited))
                    dfs(nextX, nextY, water, visited);
            }
        }
    }

    private int countIslands(int[][] water) {
        int row = water.length;
        int col = water[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isSafe(i, j, water, visited)) {
                    count += 1;
                    dfs(i, j, water, visited);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] water = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        ConnectedIslands obj = new ConnectedIslands();
        System.out.println(obj.countIslands(water));
    }

}
