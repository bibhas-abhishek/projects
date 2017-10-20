import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 20 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TwoSum
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3, 2, 4}, 6);
        Arrays.stream(result).mapToObj(i1 -> i1 + " ").forEach(System.out::print);
    }

    private static int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int complement = target - num[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i)
                return new int[]{hashMap.get(complement), i};
            hashMap.put(num[i], i);
        }
        return new int[]{-1, -1};
    }

}
