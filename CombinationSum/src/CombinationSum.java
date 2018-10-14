import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 12 Oct 2018
 * https://leetcode.com/problems/combination-sum/description/
 * https://leetcode.com/problems/combination-sum-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/CombinationSum
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumUtil(candidates, new ArrayList<>(), result, target, 0);
        return result;
    }

    private void combinationSumUtil(int[] arr, List<Integer> list, List<List<Integer>> result,
                                    int remaining, int index) {
        if (remaining < 0)
            return;

        if (remaining == 0)
            result.add(new ArrayList<>(list));

        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            combinationSumUtil(arr, list, result, remaining - arr[i], i);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumUtil2(candidates, new ArrayList<>(), result, target, 0);
        return result;
    }

    private void combinationSumUtil2(int[] arr, List<Integer> list, List<List<Integer>> result,
                                     int remaining, int index) {
        if (remaining < 0)
            return;

        if (remaining == 0)
            result.add(new ArrayList<>(list));

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;

            list.add(arr[i]);
            combinationSumUtil2(arr, list, result, remaining - arr[i], i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = {7, 6, 3, 2};
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));

        int[] candidates2 = {10, 1, 2, 7, 6, 1, 5};
        int target2 = 8;
        System.out.println(obj.combinationSum2(candidates2, target2));
    }

}
