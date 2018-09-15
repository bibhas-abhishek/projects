import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 14 Sep 2018
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/IterativePreorder
 */

public class IterativePreorder {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            result.add(stack.pop().val);
            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        List<Integer> result = preorderTraversal(root);
        result.stream().mapToInt(e -> e).mapToObj(e -> e + " ").forEach(System.out::print);
    }

}
