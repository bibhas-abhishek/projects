/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 13 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/FenwickTree
 **/

/**
 * A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 *
 * Space complexity: O(n)
 * Time complexity to create: O(nlogn)
 * Time complexity to update: O(logn)
 * Time complexity to get prefix sum: O(logn)
 */

public class FenwickTree {

    public static void main(String[] args) {
        int input[] = {1, 2, 3, 4, 5, 6, 7};
        int[] binaryIndexedTree = createBinaryIndexedTree(input);
        System.out.println(getSum(binaryIndexedTree, 6));
    }

    private static int getParent(int index) {
        return index - (index & -index);
    }

    private static int getNext(int index) {
        return index + (index & -index);
    }

    private static int[] createBinaryIndexedTree(int[] input) {
        int[] binaryIndexedTree = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++) // build tree from index 1->7. index 0 in tree is a dummy.
            createBinaryIndexedTreeUtil(binaryIndexedTree, input[i - 1], i); // i is the index in BIT

        return binaryIndexedTree;
    }

    private static void createBinaryIndexedTreeUtil(int[] binaryIndexedTree, int value, int index) {
        while (index < binaryIndexedTree.length) {
            binaryIndexedTree[index] += value;
            index = getNext(index);
        }
    }

    private static int getSum(int[] binaryIndexedTree, int index) {
        index += 1;
        int sum = 0;
        while (index > 0) {
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

}
