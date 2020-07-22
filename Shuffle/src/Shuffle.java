import java.util.Arrays;

/*https://leetcode.com/problems/shuffle-an-array/*/

public class Shuffle {

    private int[] nums;

    public Shuffle(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }

        int[] numClone = nums.clone();
        for (int i = 0; i < numClone.length; i++) {
            int k = rand(0, i);
            int temp = numClone[k];
            numClone[k] = numClone[i];
            numClone[i] = temp;
        }
        return numClone;
    }

    private int rand(int i, int j) {
        return i + (int) (Math.random() * (j - 1 + 1));
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(new Shuffle(nums).shuffle()));
    }
}
