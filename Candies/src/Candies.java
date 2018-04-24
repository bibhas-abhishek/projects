import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 24 Apr 2018
 * https://www.hackerrank.com/challenges/candies/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/Candies
 **/

public class Candies {

    private static int candies(int n, int[] input) {
        int minCandies = 0;
        int[] array = new int[input.length + 2];
        int[] candies = new int[array.length];
        array[0] = array[array.length - 1] = Integer.MAX_VALUE;
        System.arraycopy(input, 0, array, 1, input.length);
        for (int i = 1; i <= array.length - 2; i++) {            // populate valleys
            if (array[i] <= array[i - 1] && array[i] <= array[i + 1])
                candies[i] = 1;
        }

        for (int i = 1; i <= array.length - 2; i++) {            // populate rises
            if (array[i] > array[i - 1] && array[i] <= array[i + 1])
                candies[i] = candies[i - 1] + 1;
        }

        for (int i = array.length - 3; i >= 1; i--) {            // populate falls
            if (array[i] <= array[i - 1] && array[i] > array[i + 1])
                candies[i] = candies[i + 1] + 1;
        }

        for (int i = array.length - 3; i >= 1; i--) {            // populate peaks
            if (array[i] > array[i - 1] && array[i] > array[i + 1])
                candies[i] = Math.max(candies[i - 1], candies[i + 1]) + 1;
        }

        for (int i = 0; i < candies.length; i++)
            minCandies += candies[i];
        return minCandies;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2};
        System.out.println(candies(input.length, input));
    }

}
