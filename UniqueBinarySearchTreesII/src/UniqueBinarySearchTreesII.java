import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 15 Apr 2018
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * https://github.com/bibhas-abhishek/projects/tree/master/UniqueBinarySearchTreesII
 **/

public class UniqueBinarySearchTreesII {

    private static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }

    }

    private static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return Collections.emptyList();
        else
            return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        if (start > end)
            return Collections.singletonList(null);

        List<TreeNode> trees = new LinkedList<>();
        for (int root = start; root <= end; root++) {
            List<TreeNode> leftSubtrees = generateTrees(start, root - 1);
            List<TreeNode> rightSubtrees = generateTrees(root + 1, end);

            for (TreeNode leftTree : leftSubtrees) {
                for (TreeNode rightTree : rightSubtrees) {
                    TreeNode node = new TreeNode(root);
                    node.left = leftTree;
                    node.right = rightTree;
                    trees.add(node);
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }

}
