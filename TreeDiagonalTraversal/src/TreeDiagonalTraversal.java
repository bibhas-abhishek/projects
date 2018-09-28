import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 01 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/TreeDiagonalTraversal
 **/

public class TreeDiagonalTraversal {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printDiagonalTree(root);
    }

    private static void printDiagonalTree(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>((o1, o2) -> o2 - o1);
        map = diagonalMapUtil(root, 0, map);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            System.out.println(entry.getValue());
    }

    private static Map<Integer, List<Integer>> diagonalMapUtil(TreeNode root, int hd, Map<Integer, List<Integer>> map) {
        if (root == null)
            return map;

        List<Integer> list = map.get(hd);
        if (list == null)
            list = new ArrayList<>();

        list.add(root.val);
        map.put(hd, list);

        diagonalMapUtil(root.right, hd, map);
        diagonalMapUtil(root.left, hd - 1, map);
        return map;
    }

}
