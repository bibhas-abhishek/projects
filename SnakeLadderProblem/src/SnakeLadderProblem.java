import java.util.LinkedList;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 03 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SnakeLadderProblem
 */

public class SnakeLadderProblem {

    private class Tile {

        int pos;
        int dist;

    }

    private int getMinDiceThrows(int move[], int n) {
        int visited[] = new int[n];
        Queue<Tile> queue = new LinkedList<>();
        Tile root = new Tile();
        root.pos = 0;
        root.dist = 0;

        visited[0] = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove();
            int index = root.pos;
            if (index == n - 1)
                break;

            for (int i = index + 1; i <= (index + 6) && i < n; i++) {
                if (visited[i] == 0) {
                    Tile child = new Tile();
                    visited[i] = 1;
                    if (move[i] != -1)
                        child.pos = move[i];
                    else
                        child.pos = i;

                    child.dist = (root.dist + 1);
                    queue.add(child);
                }
            }
        }
        return root.dist;
    }

    public static void main(String[] args) {
        int n = 30;
        int moves[] = new int[n];
        for (int i = 0; i < n; i++)
            moves[i] = -1;

        // ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        SnakeLadderProblem obj = new SnakeLadderProblem();
        System.out.println(obj.getMinDiceThrows(moves, n));
    }

}
