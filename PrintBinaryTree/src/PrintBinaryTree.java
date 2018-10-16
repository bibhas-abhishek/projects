import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 19 Apr 2018
 * https://leetcode.com/problems/print-binary-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/PrintBinaryTree
 **/

public class PrintBinaryTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] resMatrix = new String[height][(1 << height) - 1];
        for (String[] innerRow : resMatrix)
            Arrays.fill(innerRow, "");

        fillMatrix(resMatrix, root, 0, 0, resMatrix[0].length - 1);
        List<List<String>> result = new ArrayList<>();
        for (String[] innerRow : resMatrix)
            result.add(Arrays.asList(innerRow));

        return result;
    }

    public void fillMatrix(String[][] resMatrix, TreeNode root, int level, int l, int r) {
        if (root == null)
            return;

        int mid = (l + r) / 2;
        resMatrix[level][mid] = String.valueOf(root.val);
        fillMatrix(resMatrix, root.left, level + 1, l, mid - 1);
        fillMatrix(resMatrix, root.right, level + 1, mid + 1, r);
    }


    // columns need to be 1 << height - 1
    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        PrintBinaryTree obj = new PrintBinaryTree();
        System.out.println(obj.printTree(root));
    }

}
