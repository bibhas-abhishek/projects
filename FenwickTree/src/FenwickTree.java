/*https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/*/

public class FenwickTree {

    private int getParent(int index) {
        return index - (index & -index);
    }

    private int getNext(int index) {
        return index + (index & -index);
    }

    public int[] createBinaryIndexedTree(int[] input) {
        int[] binaryIndexedTree = new int[input.length + 1]; // index 0 in tree is a dummy
        for (int i = 1; i <= input.length; i++) {
            createBinaryIndexedTreeUtil(binaryIndexedTree, input[i - 1], i);
        }
        return binaryIndexedTree;
    }

    private void createBinaryIndexedTreeUtil(int[] binaryIndexedTree, int value, int index) {
        while (index < binaryIndexedTree.length) {
            binaryIndexedTree[index] += value;
            index = getNext(index);
        }
    }

    public int getSum(int[] binaryIndexedTree, int index) {
        index += 1;
        int sum = 0;
        while (index > 0) {
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

    public static void main(String[] args) {
        FenwickTree obj = new FenwickTree();
        int[] input = { 1, 2, 3, 4, 5, 6, 7 };
        int[] binaryIndexedTree = obj.createBinaryIndexedTree(input);
        System.out.println(obj.getSum(binaryIndexedTree, 2));
    }
}
