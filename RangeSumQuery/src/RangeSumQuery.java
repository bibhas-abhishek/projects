/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 24 Oct 2018
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/RangeSumQuery
 */

public class RangeSumQuery {

    private int[] binaryIndexedTree;
    private int[] input;

    private int getParent(int index) {
        return index - (index & -index);
    }

    private int getNext(int index) {
        return index + (index & -index);
    }

    public RangeSumQuery(int[] nums) {
        input = nums;
        binaryIndexedTree = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++)
            updateTree(i, nums[i - 1]);
    }

    private void updateTree(int i, int delta) {
        while (i < binaryIndexedTree.length) {
            binaryIndexedTree[i] += delta;
            i = getNext(i);
        }
    }

    public void update(int i, int val) {
        updateTree(i, val - input[i]);
        input[i] = val;
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return getPrefixSum(j);

        return getPrefixSum(j) - getPrefixSum(i - 1);
    }

    private int getPrefixSum(int index) {
        index += 1;
        int sum = 0;
        while (index > 0) {
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

    public static void main(String[] args) {
        int input[] = {1, 3, 5};
        RangeSumQuery obj = new RangeSumQuery(input);
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }

}
