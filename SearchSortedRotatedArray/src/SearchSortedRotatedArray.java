/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 31 Mar 2018
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SearchSortedRotatedArray
 **/

public class SearchSortedRotatedArray {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1};
        System.out.print(searchNoDup(array, 1));
    }

    private static int searchNoDup(int[] nums, int target) {
        return searchNoDup(nums, 0, nums.length - 1, target);
    }

    private static int searchNoDup(int[] nums, int l, int r, int target) {
        if (l > r)
            return -1;
        int mid = (l + r) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[l] <= nums[mid]) {  //sorted left
            if (nums[l] <= target && nums[mid] >= target)
                return searchNoDup(nums, l, mid - 1, target);
            else
                return searchNoDup(nums, mid + 1, r, target);
        } else { //sorted right
            if (nums[r] >= target && nums[mid] <= target)
                return searchNoDup(nums, mid + 1, r, target);
            else
                return searchNoDup(nums, l, mid - 1, target);
        }
    }

    public boolean searchDup(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] < nums[end] || nums[mid] < nums[start]) { // right side is sorted or left side is unsorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) { // left side is sorted or right side is unsorted
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end--;
            }
        }
        return false;
    }

}
