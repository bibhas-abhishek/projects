/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 08 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RankFromStream
 **/

public class RankFromStream {

    private static class RankNode {
        int data;
        int leftSize;
        RankNode left;
        RankNode right;

        RankNode(int data) {
            this.data = data;
            leftSize = 0;
            left = right = null;
        }

    }

    public static void main(String[] args) {
        RankNode root = null;
        root = insertNode(root, 5);
        root = insertNode(root, 1);
        root = insertNode(root, 4);
        root = insertNode(root, 4);
        root = insertNode(root, 5);
        root = insertNode(root, 9);
        root = insertNode(root, 7);
        root = insertNode(root, 13);
        root = insertNode(root, 3);
        System.out.println(getRank(root, 1));
        System.out.println(getRank(root, 3));
        System.out.println(getRank(root, 4));
    }

    private static RankNode insertNode(RankNode root, int key) {
        if (root == null)
            return new RankNode(key);
        else if (key <= root.data) {
            root.left = insertNode(root.left, key);
            root.leftSize += 1;
        } else
            root.right = insertNode(root.right, key);

        return root;
    }

    private static int getRank(RankNode root, int key) {
        if (root == null)
            return -1;
        if (key == root.data)
            return root.leftSize;
        else if (key < root.data)
            return getRank(root.left, key);
        else {
            return root.leftSize + getRank(root.right, key) + 1;
        }
    }

}
