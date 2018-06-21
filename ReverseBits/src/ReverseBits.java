/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Jun 2018
 * https://leetcode.com/problems/reverse-bits/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ReverseBits
 **/

public class ReverseBits {

    private static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596) == 964176192);
    }

}
