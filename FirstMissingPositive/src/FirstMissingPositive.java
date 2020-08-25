public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int newPos = nums[i] - 1;
            while(nums[i] > 0 && nums[i] <= n && nums[newPos] != nums[i]) {
                swap(nums, newPos, i);
                newPos = nums[i] - 1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive driver = new FirstMissingPositive();
        int[] array = { 3, 4, -1, 1 };
        System.out.println(driver.firstMissingPositive(array));
    }
}
