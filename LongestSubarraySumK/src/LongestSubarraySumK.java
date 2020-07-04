import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/longest-sub-array-sum-k/

public class LongestSubarraySumK {

    public int longestSubarraySumK(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLength = i + 1;
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        System.out.println(new LongestSubarraySumK().longestSubarraySumK(arr, k));
    }
}
