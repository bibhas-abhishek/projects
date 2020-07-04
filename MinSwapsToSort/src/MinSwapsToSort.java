import java.util.ArrayList;
import java.util.Arrays;

import javafx.util.Pair;

// https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/

public class MinSwapsToSort {

    public int minSwaps(int[] arr) {
        int n = arr.length;
        ArrayList<Pair<Integer, Integer>> arrayPair = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayPair.add(new Pair<>(arr[i], i));
        }

        arrayPair.sort((o1, o2) -> o1.getKey() - o2.getKey());
        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, false);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || arrayPair.get(i).getValue() == i) {
                continue;
            }

            int cycle_size = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arrayPair.get(j).getValue();
                cycle_size++;
            }

            if (cycle_size > 0) {
                result += (cycle_size - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 4, 3, 2 };
        System.out.println(new MinSwapsToSort().minSwaps(array));
    }
}
