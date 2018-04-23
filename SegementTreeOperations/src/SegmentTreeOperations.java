import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 23 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SegementTreeOperations
 **/

public class SegmentTreeOperations {

    private static int nextPowerOf2(int n) {
        int count = 0;
        if (n > 0 && (n & (n - 1)) == 0)
            return n;

        while (n != 0) {
            n >>= 1;
            count += 1;
        }
        return 1 << count;
    }


    private static int[] createSegmentTree(int[] array) {
        int nextPowof2 = nextPowerOf2(array.length);
        int[] segmentTree = new int[2 * nextPowof2 - 1];
        Arrays.fill(segmentTree, Integer.MAX_VALUE);
        createSegmentTreeUtil(array, segmentTree, 0, array.length - 1, 0);
        return segmentTree;
    }

    private static void createSegmentTreeUtil(int[] array, int[] segmentTree, int low, int high, int segTreeIndex) {
        if (low == high) {
            segmentTree[segTreeIndex] = array[low];
            return;
        }
        int mid = (low + high) / 2;
        createSegmentTreeUtil(array, segmentTree, low, mid, 2 * segTreeIndex + 1);
        createSegmentTreeUtil(array, segmentTree, mid + 1, high, 2 * segTreeIndex + 2);
        segmentTree[segTreeIndex] = Math.min(segmentTree[2 * segTreeIndex + 1], segmentTree[2 * segTreeIndex + 2]);
    }

    private static int rangeMinQuery(int[] segmentTree, int qLow, int qHigh, int inputLength) {
        return rangeMinQueryUtil(segmentTree, 0, inputLength - 1, qLow, qHigh, 0);
    }

    private static int rangeMinQueryUtil(int[] segmentTree, int low, int high, int qLow, int qHigh, int pos) {
        if (qLow > high || qHigh < low)     // no overlap
            return Integer.MAX_VALUE;

        if (qLow <= low && qHigh >= high)   // complete overlap low-high lies between qLow-qHigh
            return segmentTree[pos];

        int mid = (low + high) / 2;
        return Math.min(rangeMinQueryUtil(segmentTree, low, mid, qLow, qHigh, 2 * pos + 1),
                rangeMinQueryUtil(segmentTree, mid + 1, high, qLow, qHigh, 2 * pos + 2));
    }

    public static void main(String[] args) {
        int array[] = {0, 3, 4, 2, 1, 6, -1};
        int[] segmentTree = createSegmentTree(array);
        for (int i : segmentTree)
            System.out.print(i + " ");
        System.out.println();
        System.out.println(rangeMinQuery(segmentTree, 0, 3, array.length));
        System.out.println(rangeMinQuery(segmentTree, 1, 6, array.length));
    }

}
