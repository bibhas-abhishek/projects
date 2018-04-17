/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 17 Apr 2018
 * https://leetcode.com/problems/number-of-1-bits/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/Numberof1Bits
 **/

public class Numberof1Bits {

    private static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

}
