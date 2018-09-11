import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 10 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestZeroLengthSubarray
 */

public class LongestZeroLengthSubarray {

    private static int maxLength(int arr[]) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 && maxLength == 0)
                maxLength = 1;

            if (sum == 0)
                maxLength = i + 1;

            Integer prevLoc = hashMap.get(sum);
            if (prevLoc != null)
                maxLength = Math.max(maxLength, i - prevLoc);
            else
                hashMap.put(sum, i);
        }
        return maxLength;
    }

    public static void main(String arg[]) {
        int arr[] = {15, -2, -13, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum sub array is: " + maxLength(arr));
    }

}
