import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 06 May 2018
 * https://leetcode.com/problems/summary-ranges/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SummaryRanges
 **/

public class SummaryRanges {

    private static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;

        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }

        int start = 0, end = 0, i = 1;
        while (true) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                result.add(start == end ? nums[start] + "" : nums[start] + "->" + nums[end]);
                start = end = i;
            } else
                end += 1;

            if (i == nums.length)
                break;
            i += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }

}
