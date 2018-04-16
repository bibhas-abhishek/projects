import apple.laf.JRSUIUtils;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ConstructTreeFromLevelorderInorder
 **/

public class ConstructTreeFromLevelorderInorder {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private static TreeNode constructTree(int[] inorder, int[] levelorder) {
        return constructTree(inorder, levelorder, 0, inorder.length - 1);
    }

    private static TreeNode constructTree(int[] inorder, int[] levelorder, int start, int end) {
        if (start > end)
            return null;

        int key = levelorder[0]; // first element of level order is root
        TreeNode root = new TreeNode(key);

        //search in inorder for index of root
        int index = binarySearch(inorder, key, start, end);

        // extracted level order elements that existed in inorder in the specified range
        int[] leftSubtree = extractArray(inorder, levelorder, start, index - 1);
        int[] rightSubtree = extractArray(inorder, levelorder, index + 1, end);

        root.left = constructTree(inorder, leftSubtree, start, index - 1);
        root.right = constructTree(inorder, rightSubtree, index + 1, end);
        return root;
    }

    /**
     * gets the array of level order elements that exist in inorder array in the start->end range
     * first element of level order is root node that is already processed
     *
     * @param inorder
     * @param levelorder
     * @param start
     * @param end
     * @return
     */
    private static int[] extractArray(int[] inorder, int[] levelorder, int start, int end) {
        int[] result = new int[end - start + 1];
        int index = 0;
        for (int i = 1; i < levelorder.length; i++) {
            int searchIndex = binarySearch(inorder, levelorder[i], start, end);
            if (searchIndex != -1)
                result[index++] = inorder[searchIndex]; // insert the inorder element
        }
        return result;
    }

    private static int binarySearch(int[] array, int key, int start, int end) {
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

    private static void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }


    public static void main(String[] args) {
        int inorder[] = {4, 8, 10, 12, 14, 20, 22};
        int levelorder[] = {20, 8, 22, 4, 12, 10, 14};
        TreeNode root = constructTree(inorder, levelorder);
        inorderDFS(root);
    }

}
