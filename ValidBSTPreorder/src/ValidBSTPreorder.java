import java.util.Stack;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ValidBSTPreorder
 */

public class ValidBSTPreorder {

    public boolean canRepresentBST(int preorder[]) {
        int root = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < root)                                     // found a lesser element than root after finding a next greater element
                return false;

            while (!stack.isEmpty() && preorder[i] > stack.peek())      // keep popping element from stack until stack top is less than current element
                root = stack.pop();                                     // make last popped element as root. current element is greater than the the root.
            // preorder[i] is the next greater element for the root here.
            stack.push(preorder[i]);
        }
        return true;
    }

    public static void main(String args[]) {
        ValidBSTPreorder obj = new ValidBSTPreorder();
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        System.out.println(obj.canRepresentBST(pre1));

        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        System.out.println(obj.canRepresentBST(pre2));
    }

}
