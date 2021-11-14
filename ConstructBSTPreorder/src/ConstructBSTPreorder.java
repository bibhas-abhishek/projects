/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: ConstructBSTPreorder
*- 15 Nov 2021 12:12 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal
-------------------------------------------*/

public class ConstructBSTPreorder {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int index;

    public TreeNode bstFromPreorderBF(int[] preorder, int low, int high) {
        if (low > high || index >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index += 1;
        int i;
        for (i = low; i <= high; i++) {
            if (preorder[i] > root.val) {
                break;
            }
        }
        root.left = bstFromPreorderBF(preorder, index, i - 1);
        root.right = bstFromPreorderBF(preorder, i, high);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int minValue, int maxValue) {
        if (index >= preorder.length) {
            return null;
        }

        int key = preorder[index];
        TreeNode root = null;
        if (key > minValue && key < maxValue) {
            root = new TreeNode(key);
            index += 1;
            root.left = bstFromPreorder(preorder, minValue, key);
            root.right = bstFromPreorder(preorder, key, maxValue);
        }
        return root;
    }

    public static void main(String[] args) {
        ConstructBSTPreorder driver = new ConstructBSTPreorder();
        int[] preorder = new int[] { 10, 5, 1, 7, 40, 50 };
        TreeNode root = driver.bstFromPreorder(preorder);
    }
}
