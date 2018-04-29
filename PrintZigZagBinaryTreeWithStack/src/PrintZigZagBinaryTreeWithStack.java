import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/PrintZigZagBinaryTreeWithStack
 */
public class PrintZigZagBinaryTreeWithStack {

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
        System.out.println(printZigZgOrderWithStack(root));
    }

    private static List<List<Integer>> printZigZgOrderWithStack(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        s2.push(root);
        List<Integer> level = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s2.isEmpty()) {
                TreeNode temp = s2.pop();
                level.add(temp.val);
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }

            if (level.size() > 0)
                result.add(level);
            level = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode temp = s1.pop();
                level.add(temp.val);
                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);

            }
            if (level.size() > 0)
                result.add(level);
            level = new ArrayList<>();
        }
        return result;
    }

}
