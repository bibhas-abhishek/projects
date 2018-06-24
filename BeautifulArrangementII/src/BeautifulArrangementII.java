import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Jun 2018
 * https://leetcode.com/problems/beautiful-arrangement-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/BeautifulArrangementII
 **/

public class BeautifulArrangementII {

    private static int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int l = 1, r = n;
        for (int i = 0; l <= r; i++)
            result[i] = (k > 1) ? (k-- % 2 != 0 ? l++ : r--) : l++;
        return result;
    }

    public static void main(String[] args) {
        int[] result = constructArray(9, 5);
        Arrays.stream(result).mapToObj(e -> e + " ").forEach(System.out::print);
    }

}
