import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 06 May 2018
 * https://leetcode.com/problems/binary-trees-with-factors/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreesWithFactors
 **/

public class BinaryTreesWithFactors {

    private static int numFactoredBinaryTrees(int[] A) {
        if (A.length == 0)
            return 0;

        Arrays.sort(A);
        Map<Integer, Long> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            long count = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0 && hashMap.containsKey(A[i] / A[j]))
                    count += hashMap.get(A[j]) * hashMap.get(A[i] / A[j]);
            }
            hashMap.put(A[i], count);
        }

        long result = 0;
        for (long val : hashMap.values())
            result += val;
        return (int) (result % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        int[] A = {2, 4};
        System.out.println(numFactoredBinaryTrees(A));
    }

}
