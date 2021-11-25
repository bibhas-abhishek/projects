/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: ConnectedIslands
*- 23 Nov 2021 7:14 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/surrounded-regions
-------------------------------------------*/

public class ConnectedIslands {

    private boolean isValidMove(int x, int y, int[][] water, boolean[][] visited) {
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
                if (isValidMove(nextX, nextY, water, visited)) {
                    dfs(nextX, nextY, water, visited);
                }
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
                if (isValidMove(i, j, water, visited)) {
                    dfs(i, j, water, visited);
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] water =
                {
                        { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0 },
                        { 1, 0, 1, 0, 1 } };
        ConnectedIslands obj = new ConnectedIslands();
        System.out.println(obj.countIslands(water));
    }
}
