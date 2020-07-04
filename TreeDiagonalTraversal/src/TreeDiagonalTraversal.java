import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 01 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/TreeDiagonalTraversal
 **/

public class TreeDiagonalTraversal {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public void printDiagonalTree(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>((o1, o2) -> o2 - o1);
        map = printDiagonalTreeUtil(root, 0, map);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private Map<Integer, List<Integer>> printDiagonalTreeUtil(TreeNode root, int hd, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return map;
        }

        List<Integer> list = map.get(hd);
        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(root.val);
        map.put(hd, list);
        printDiagonalTreeUtil(root.right, hd, map);
        printDiagonalTreeUtil(root.left, hd - 1, map);
        return map;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        new TreeDiagonalTraversal().printDiagonalTree(root);
    }
}
