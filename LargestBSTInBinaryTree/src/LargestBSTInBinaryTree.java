public class LargestBSTInBinaryTree {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private static class Wrapper {

        int     min;
        int     max;
        int     size;
        boolean isBST;

        Wrapper() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            size = 0;
            isBST = true;
        }
    }

    private Wrapper getMaxBST(TreeNode root) {
        if (root == null) {
            return new Wrapper();
        }

        Wrapper leftWrapper = getMaxBST(root.left);
        Wrapper rightWrapper = getMaxBST(root.right);
        Wrapper wrapper = new Wrapper();
        if (!leftWrapper.isBST || !rightWrapper.isBST || root.val < leftWrapper.max || root.val >= rightWrapper.min) {
            wrapper.isBST = false;
            wrapper.size = Math.max(leftWrapper.size, rightWrapper.size);
            return wrapper;
        }

        wrapper.isBST = true;
        wrapper.size = leftWrapper.size + rightWrapper.size + 1;
        wrapper.min = root.left == null ? root.val : leftWrapper.min;
        wrapper.max = root.right == null ? root.val : rightWrapper.max;
        return wrapper;
    }

    TreeNode buildTree() {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(18);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(19);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(60);
        root.left.left.right = new TreeNode(15);
        root.left.right.left = new TreeNode(18);
        root.left.right.right = new TreeNode(25);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(40);
        root.right.right.left = new TreeNode(55);
        root.right.right.right = new TreeNode(70);
        root.right.left.left.right = new TreeNode(25);
        return root;
    }

    public static void main(String[] args) {
        LargestBSTInBinaryTree obj = new LargestBSTInBinaryTree();
        TreeNode root = obj.buildTree();
        System.out.println(obj.getMaxBST(root).size);
    }
}
