import java.util.Arrays;

/*
https://leetcode.com/problems/next-permutation/
 */

public class NextPermutation {

    public int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i -= 1;
        }

        if (i >= 0) {
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) {
                j -= 1;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i += 1;
            j -= 1;
        }
    }

    public static void main(String[] args) {
        NextPermutation driver = new NextPermutation();
        int[] array = new int[] { 9, 5, 6, 4, 3, 2 };
        System.out.println(Arrays.toString(driver.nextPermutation(array)));
    }
}
