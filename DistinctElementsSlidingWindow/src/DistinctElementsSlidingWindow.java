import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/DistinctElementsSlidingWindow
 */

public class DistinctElementsSlidingWindow {

    public void countWindowDistinct(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int i = 0;
        for (i = 0; i < k; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                count += 1;
            } else
                map.put(arr[i], map.get(arr[i]) + 1);
        }

        System.out.print(count + " ");
        while (i < arr.length) {
            // remove first element
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
                count -= 1;
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }

            // add new element
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                count += 1;
            } else
                map.put(arr[i], map.get(arr[i]) + 1);
            System.out.print(count + " ");
            i += 1;
        }
    }

    public static void main(String[] args) {
        DistinctElementsSlidingWindow obj = new DistinctElementsSlidingWindow();
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        obj.countWindowDistinct(arr, 4);
    }

}
