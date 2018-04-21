import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 20 Apr 2018
 * https://www.hackerrank.com/challenges/array-splitting/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/NikitaAndTheGame
 **/

public class NikitaAndTheGame {

    private static int countMaxWays(int[] array) {
        int n = array.length;
        if (n < 2)
            return 0;

        int leftSum = 0, rightSum = 0, pIndex = 0;
        boolean isEqual = false;
        for (int i = 0; i < n; i++)
            rightSum += array[i];

        while (pIndex < n) {
            leftSum += array[pIndex];
            rightSum -= array[pIndex];
            if (leftSum == rightSum) {
                isEqual = true;
                break;
            }
            pIndex++;
        }

        if (!isEqual) // can't be split into equal partition arrays
            return 0;
        return 1 + Math.max(countMaxWays(Arrays.copyOfRange(array, 0, pIndex + 1)),
                countMaxWays(Arrays.copyOfRange(array, pIndex + 1, n)));
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6};
        System.out.println(countMaxWays(array));
    }

}
