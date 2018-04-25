/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 25 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SubRectangularMatrixWithMaxSum
 **/

public class SubRectangularMatrixWithMaxSum {

    private static class Result {

        int leftBound;
        int rightBound;
        int topBound;
        int bottomBound;
        int maxSum;

        @Override
        public String toString() {
            return "Result{" +
                    "leftBound=" + leftBound +
                    ", rightBound=" + rightBound +
                    ", topBound=" + topBound +
                    ", bottomBound=" + bottomBound +
                    ", maxSum=" + maxSum +
                    '}';
        }

    }

    private static class KadaneResult {

        int maxSum;
        int start;
        int end;

        KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }

    }

    private static Result maxSum(int input[][]) {
        int rows = input.length;
        int cols = input[0].length;
        int temp[] = new int[rows];
        Result res = new Result();
        for (int left = 0; left < cols; left++) {
            for (int i = 0; i < temp.length; i++)
                temp[i] = 0;

            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++)
                    temp[i] += input[i][right];

                KadaneResult kr = getTempArrayBounds(temp);
                if (kr.maxSum > res.maxSum) {
                    res.maxSum = kr.maxSum;
                    res.topBound = kr.start;
                    res.bottomBound = kr.end;
                    res.leftBound = left;
                    res.rightBound = right;
                }
            }
        }
        return res;
    }

    private static KadaneResult getTempArrayBounds(int[] array) {
        int maxSumSoFar = 0, max = 0, currentStart = 0, maxStart = 0, maxEnd = 0;
        for (int i = 0; i < array.length; i++) {
            maxSumSoFar += array[i];
            if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
                currentStart = i + 1;
            }

            if (maxSumSoFar > max) {
                max = maxSumSoFar;
                maxStart = currentStart;
                maxEnd = i;
            }
        }
        return new KadaneResult(max, maxStart, maxEnd);
    }


    public static void main(String args[]) {
        int input[][] = {{2, 1, -3, -4, 5},
                {0, 6, 3, 4, 1},
                {2, -2, -1, 4, -5},
                {-3, 3, 1, 0, 3}};
        System.out.println(maxSum(input));
    }

}
