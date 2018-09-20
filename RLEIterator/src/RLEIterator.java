/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 20 Sep 2018
 * https://leetcode.com/problems/rle-iterator/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/RLEIterator
 */

public class RLEIterator {

    private static int[] rle;
    private static int i, j;

    public RLEIterator(int[] A) {
        rle = A;
        i = 0;
        j = 1;
    }

    private int next(int n) {
        // rle[i] -> quantity
        // rle[j] -> value

        while (n > 0) {
            while (i < rle.length && j < rle.length && rle[i] <= 0) {
                i += 2;
                j += 2;
            }

            if (i >= rle.length || j >= rle.length)
                return -1;

            rle[i] -= 1;

            if (n == 1) {
                return rle[j];
            }
            n -= 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int A[] = {3, 8, 0, 9, 2, 5};
        RLEIterator rleIterator = new RLEIterator(A);
        System.out.println(rleIterator.next(2));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(2));
    }

}
