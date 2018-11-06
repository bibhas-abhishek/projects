import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 05 Nov 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestSubarrayDivisibleK
 */

public class LongestSubarrayDivisibleK {

    public int solve(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] mod = new int[n];
        int sum = 0, result = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            mod[i] = sum % k;
        }

        for (int i = 0; i < n; i++) {
            if (mod[i] == 0)
                result = i + 1;

            if (!map.containsKey(mod[i]))
                map.put(mod[i], i);
            else
                result = Math.max(result, i - map.get(mod[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 4, 1};
        int k = 4;
        System.out.println(new LongestSubarrayDivisibleK().solve(arr, k));
    }

}
