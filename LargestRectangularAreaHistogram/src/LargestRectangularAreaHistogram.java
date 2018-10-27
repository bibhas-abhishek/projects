import java.util.Stack;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Sep 2018
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LargestRectangularAreaHistogram
 */

public class LargestRectangularAreaHistogram {

    private static int getMaxArea(int[] hist, int n) {
        Stack<Integer> stack = new Stack<>(); // stack stores indices
        int maxArea = 0, top, topArea, i = 0;
        while (i < n) {
            if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) // if current element >= stack top, then push to stack
                stack.push(i++);
            else {
                top = stack.pop();
                if (stack.isEmpty())
                    topArea = hist[top] * i;
                else
                    topArea = hist[top] * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, topArea);
            }
        }

        while (!stack.isEmpty()) {
            top = stack.pop();
            if (stack.isEmpty())
                topArea = hist[top] * i;
            else
                topArea = hist[top] * (i - stack.peek() - 1);
            maxArea = Math.max(maxArea, topArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(getMaxArea(hist, hist.length));
    }

}
