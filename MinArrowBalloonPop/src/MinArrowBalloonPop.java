import java.util.Arrays;
import java.util.Comparator;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 01 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MinArrowBalloonPop
 **/

public class MinArrowBalloonPop {

    public static void main(String[] args) {
        int[][] balloons = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.print(findMinArrowShots(balloons));
    }

    private static int findMinArrowShots(int[][] balloons) {
        if (balloons.length == 0)
            return 0;
        Arrays.sort(balloons, new Comparator<int[]>() { // sort balloon endpoints by their end points
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int arrowCount = 1;
        int arrowPos = balloons[0][1]; // place arrow at the end of first balloon
        for (int i = 1; i < balloons.length; i++) { // start with 2nd balloon
            if (balloons[i][0] <= arrowPos)
                continue; // as long it keep bursting balloon keep count same. Balloon will pop as long as
                        // the arrow is greater than their start points

            arrowCount++; // increase count if this balloon cant be burst
            arrowPos = balloons[i][1]; // set arrowPos to the end of this balloon and continue
        }
        return arrowCount;
    }

}
