import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 24 Dec 2017
 * https://leetcode.com/problems/3sum/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ThreeSum/
 **/

public class ThreeSum {

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.print(threeSum(array));
    }

    private static List<List<Integer>> threeSum(int[] array) {
        List<List<Integer>> threeSum = new LinkedList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i == 0 || (i > 0 && array[i] != array[i - 1])) {
                int j = i + 1;
                int k = array.length - 1;
                while (j < k) {
                    int sum = array[i] + array[j] + array[k];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>(Arrays.asList(array[i], array[j], array[k]));
                        threeSum.add(list);
                        while (j < k && array[j] == array[j + 1])
                            j++;
                        while (j < k && array[k] == array[k - 1])
                            k--;
                        j++;
                        k--;
                    } else if (sum < 0)
                        j++;
                    else
                        k--;
                }
            }
        }

        return threeSum;
    }

}
