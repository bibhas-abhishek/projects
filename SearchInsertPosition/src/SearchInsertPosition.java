/**
 * Bibhas Abhishek
 * bibhas.abhishek@ril.com
 * 08 Jun 2018
 * https://leetcode.com/problems/search-insert-position/description/
 * SearchInsertPosition: Copyright JioMoney 2018
 **/

public class SearchInsertPosition {

    private static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return target < nums[mid] ? mid : mid + 1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 6, 8};
        System.out.println(searchInsert(nums, 0));
    }

}
