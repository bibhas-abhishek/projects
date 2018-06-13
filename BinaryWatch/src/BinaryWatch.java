import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Jun 2018
 * https://leetcode.com/problems/binary-watch/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryWatch
 **/

public class BinaryWatch {

    private static List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 59; m++) {
                if (bitCount(h) + bitCount(m) == num)
                    result.add(String.format("%d:%02d", h, m));
            }
        }
        return result;
    }

    private static int bitCount(int n) {
        int bitCount = 0;
        while (n > 0) {
            bitCount += n & 1;
            n >>= 1;
        }
        return bitCount;
    }

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }

}
