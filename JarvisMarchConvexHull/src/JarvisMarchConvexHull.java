import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 25 Apr 2018
 * https://leetcode.com/problems/erect-the-fence/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/JarvisMarchConvexHull
 **/

public class JarvisMarchConvexHull {

    private static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    /**
     * Returns < 0 if 'b' is closer to 'a' compared to 'c', == 0 if 'b' and 'c' are same distance from 'a'
     * or > 0 if 'c' is closer to 'a' compared to 'b'.
     */
    private static int distance(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return Integer.compare(x1 * x1 + y1 * y1, x2 * x2 + y2 * y2);
    }

    /**
     * Cross product to find where c belongs in reference to vector ab.
     * If result > 0 it means 'c' is on left of ab
     * result == 0 it means 'a','b' and 'c' are collinear
     * result < 0  it means 'c' is on right of ab
     */
    private static int crossProduct(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return y2 * x1 - y1 * x2;
    }

    private static List<Point> findConvexHull(Point[] points) {
        Point start = points[0];

        // find left most point to use as start
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < start.x)
                start = points[i];
        }

        Point current = start;
        Set<Point> result = new HashSet<>();
        List<Point> collinearPoints = new ArrayList<>();
        result.add(start);
        while (true) {
            Point next = points[0]; // choose point to be assessed next
            for (int i = 1; i < points.length; i++) {
                if (points[i] == current)
                    continue;

                int cp = crossProduct(current, next, points[i]);
                if (cp > 0) {          // points[i] is on the left. make point[i] next target
                    next = points[i];
                    collinearPoints.clear();
                } else if (cp == 0) { // current, next, points[i] are collinear
                    if (distance(current, next, points[i]) < 0) { // next is closer to current. add next to collinear list and update next as point[i]
                        collinearPoints.add(next);
                        next = points[i];
                    } else
                        collinearPoints.add(points[i]); // point[i] is closer and added to collinear list
                } else {
                    // do nothing since points[i] is to the right of current->next
                }
            }

            for (Point p : collinearPoints)
                result.add(p);

            if (next == start)
                break;

            result.add(next);
            current = next;
        }
        return new ArrayList<>(result);
    }

}
