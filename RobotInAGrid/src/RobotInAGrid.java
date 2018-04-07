import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 07 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RobotInAGrid
 **/

public class RobotInAGrid {


    public static void main(String[] args) {

    }

    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return null;

        ArrayList<Point> path = new ArrayList<>();
        Map<Point, Boolean> cache = new HashMap<>();
        int lastRow = maze.length;
        int lastCol = maze[0].length;
        if (getPath(maze, lastRow, lastCol, path, cache))
            return path;
        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, Map<Point, Boolean> cache) {
        if (row < 0 || col < 0 || !maze[row][col])
            return false;

        Point p = new Point(row, col);

        if (cache.containsKey(p))
            return cache.get(p);

        boolean isAtOrigin = row == 0 && col == 0;
        boolean success = false;
        if (isAtOrigin || getPath(maze, row - 1, col, path, cache) || getPath(maze, row, col - 1, path, cache)) {
            success = true;
            path.add(p);
        }

        cache.put(p, success);
        return success;
    }

}
