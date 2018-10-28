/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 29 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreeLevelorderInorder
 */

public class BinaryTreeLevelorderInorder {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode constructTree(int[] inorder, int[] levelorder) {
        return constructTree(inorder, levelorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] inorder, int[] levelorder, int start, int end) {
        if (start > end)
            return null;

        int key = levelorder[0];
        TreeNode root = new TreeNode(key);
        int index = binarySearch(inorder, key, start, end);
        int[] leftSubtree = extractArray(inorder, levelorder, start, index - 1);
        int[] rightSubtree = extractArray(inorder, levelorder, index + 1, end);
        root.left = constructTree(inorder, leftSubtree, start, index - 1);
        root.right = constructTree(inorder, rightSubtree, index + 1, end);
        return root;
    }

    /**
     * extract level order elements that are in the inorder array in the range start -> end
     */
    private int[] extractArray(int[] inorder, int[] levelorder, int start, int end) {
        int[] result = new int[end - start + 1];
        int index = 0;
        for (int i = 1; i < levelorder.length; i++) {
            int searchIndex = binarySearch(inorder, levelorder[i], start, end);
            if (searchIndex != -1)
                result[index++] = inorder[searchIndex]; // insert the inorder element
        }
        return result;
    }

    private int binarySearch(int[] array, int key, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (array[mid] == key)
            return mid;
        else if (key < array[mid])
            return binarySearch(array, key, start, mid - 1);
        else
            return binarySearch(array, key, mid + 1, end);
    }

    public void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }


    public static void main(String[] args) {
        BinaryTreeLevelorderInorder obj = new BinaryTreeLevelorderInorder();
        int inorder[] = {4, 8, 10, 12, 14, 20, 22};
        int levelorder[] = {20, 8, 22, 4, 12, 10, 14};
        TreeNode root = obj.constructTree(inorder, levelorder);
        obj.inorderDFS(root);
    }

}
