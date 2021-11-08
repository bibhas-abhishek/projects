/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: FirstAndLastInSortedArray
*- 07 Nov 2021 4:58 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
-------------------------------------------*/

import java.util.Arrays;

public class FirstAndLastInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int last = findBound(nums, target, false);
        return new int[] { first, last };
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    begin = mid + 1;
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        FirstAndLastInSortedArray driver = new FirstAndLastInSortedArray();
        System.out.println(Arrays.toString(driver.searchRange(nums, 8)));
    }
}
