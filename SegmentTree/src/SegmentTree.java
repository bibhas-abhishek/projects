import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SegmentTree
 */

public class SegmentTree {

    private int nextPowerOf2(int n) {
        int count = 0;
        if (n > 0 && (n & (n - 1)) == 0)
            return n;

        while (n != 0) {
            n >>= 1;
            count += 1;
        }
        return 1 << count;
    }


    public int[] createSegmentTree(int[] array) {
        int nextPowerOf2 = nextPowerOf2(array.length);
        int[] segmentTree = new int[2 * nextPowerOf2 - 1];
        Arrays.fill(segmentTree, Integer.MAX_VALUE);
        createSegmentTreeUtil(array, segmentTree, 0, array.length - 1, 0);
        return segmentTree;
    }

    private void createSegmentTreeUtil(int[] array, int[] segmentTree, int low, int high, int pos) {
        if (low == high) {
            segmentTree[pos] = array[low];
            return;
        }

        int mid = (low + high) / 2;
        int leftChild = 2 * pos + 1;
        int rightChild = 2 * pos + 2;
        createSegmentTreeUtil(array, segmentTree, low, mid, leftChild);
        createSegmentTreeUtil(array, segmentTree, mid + 1, high, rightChild);
        segmentTree[pos] = Math.min(segmentTree[leftChild], segmentTree[rightChild]);
    }

    public int rangeMinQuery(int[] segmentTree, int qLow, int qHigh, int length) {
        return rangeMinQueryUtil(segmentTree, qLow, qHigh, 0, length - 1, 0);
    }

    private static int rangeMinQueryUtil(int[] segmentTree, int qLow, int qHigh, int low, int high, int pos) {
        if (qLow > high || qHigh < low)     // no overlap
            return Integer.MAX_VALUE;

        if (qLow <= low && qHigh >= high)   // complete overlap
            return segmentTree[pos];

        int mid = (low + high) / 2;
        return Math.min(rangeMinQueryUtil(segmentTree, qLow, qHigh, low, mid, 2 * pos + 1),
                rangeMinQueryUtil(segmentTree, qLow, qHigh, mid + 1, high, 2 * pos + 2));
    }

    public static void main(String[] args) {
        SegmentTree obj = new SegmentTree();
        int array[] = {0, 3, 4, 2, 1, 6, -1};
        int[] segmentTree = obj.createSegmentTree(array);
        for (int i : segmentTree)
            System.out.print(i + " ");

        System.out.println();
        System.out.println(obj.rangeMinQuery(segmentTree, 0, 3, array.length));
        System.out.println(obj.rangeMinQuery(segmentTree, 1, 6, array.length));
    }

}
