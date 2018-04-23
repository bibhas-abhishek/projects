/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 23 Apr 2018
 * https://leetcode.com/problems/power-of-two/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/PowerofTwo
 **/

public class PowerofTwo {

    private static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return true;

        boolean is1Set = false;
        while (n != 0) {
            if (is1Set)
                return false;

            if ((n & 1) == 1 && !is1Set)
                is1Set = true;

            n >>= 1;
        }
        return true;
    }

    private static int nextPowerOf2(int n) {
        int count = 0;
        if (n > 0 && (n & (n - 1)) == 0)
            return n;

        while (n != 0) {
            n >>= 1;
            count += 1;
        }
        return 1 << count;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(17));
        System.out.println(nextPowerOf2(4));
    }

}
