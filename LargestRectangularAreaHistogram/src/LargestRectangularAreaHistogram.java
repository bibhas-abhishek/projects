/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: LargestRectangularAreaHistogram
*- 10 Nov 2021 1:48 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/largest-rectangle-in-histogram
-------------------------------------------*/

import java.util.Stack;

public class LargestRectangularAreaHistogram {

    public int getMaxArea(int[] hist, int n) {
        Stack<Integer> stack = new Stack<>(); // stack stores indices
        int maxArea = 0, top, topArea, i = 0;
        while (i < n) {
            if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) { // if current element >= stack top, then push to stack
                stack.push(i++);
            } else {
                top = stack.pop();
                if (stack.isEmpty()) {
                    topArea = hist[top] * i;
                } else {
                    topArea = hist[top] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, topArea);
            }
        }

        while (!stack.isEmpty()) {
            top = stack.pop();
            if (stack.isEmpty()) {
                topArea = hist[top] * i;
            } else {
                topArea = hist[top] * (i - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, topArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangularAreaHistogram obj = new LargestRectangularAreaHistogram();
        int[] hist = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println(obj.getMaxArea(hist, hist.length));
    }
}
