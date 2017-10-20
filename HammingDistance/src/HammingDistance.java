/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 20 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/HammingDistance
 * https://leetcode.com/problems/hamming-distance/description/
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.print(hammingDistance(1, 4));
    }

    private static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }

        return count;
    }

}
