import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 30 Oct 2018
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SerializeDeserializeBinaryTree
 */

public class SerializeDeserializeBinaryTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    private final String splitter = ",";
    private final String NN = "x";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN).append(splitter);
            return;
        }

        sb.append(root.val).append(splitter);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(splitter)));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals(NN))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int i = queue.size();
            List<Integer> level = new ArrayList<>();
            while (i > 0) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);

                if (temp.right != null)
                    queue.offer(temp.right);

                i -= 1;
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serial = obj.serialize(root);
        TreeNode dRoot = obj.deserialize(serial);
        System.out.println(obj.levelOrder(dRoot));
    }

}
