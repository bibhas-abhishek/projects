import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas.abhishek@ril.com
 * 07 Jun 2018
 * https://leetcode.com/problems/subsets/description/
 * Subsets: Copyright JioMoney 2018
 **/

public class Subsets {

    private static List<List<Integer>> subsets(int[] set) {
        List<List<Integer>> result = new ArrayList<>();
        int size = 1 << set.length;
        for (int k = 0; k < size; k++)
            result.add(getSubset(k, set));
        return result;
    }

    private static List<Integer> getSubset(int k, int[] set) {
        int index = 0;
        List<Integer> subset = new ArrayList<>();
        for (int x = k; x > 0; x >>= 1) {
            if ((x & 1) == 1)
                subset.add(set[index]);
            index += 1;
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        System.out.println(subsets(set));
    }

}
