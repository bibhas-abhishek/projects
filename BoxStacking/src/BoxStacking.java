import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BoxStacking
 */

public class BoxStacking {

    private static class Box {

        int h;
        int l;
        int w;

        public Box(int h, int l, int w) {
            this.h = h;
            this.l = l;
            this.w = w;
        }

    }

    private void createBoxPermutations(Box[] input, Box[] boxPerm) {
        for (int i = 0; i < input.length; i++) {
            boxPerm[3 * i] = new Box(input[i].h, Math.max(input[i].w, input[i].l), Math.min(input[i].w, input[i].l));
            boxPerm[3 * i + 1] = new Box(input[i].l, Math.max(input[i].h, input[i].w), Math.min(input[i].h, input[i].w));
            boxPerm[3 * i + 2] = new Box(input[i].w, Math.max(input[i].l, input[i].h), Math.min(input[i].l, input[i].h));
        }
    }

    public int maxHeight(Box[] input) {
        Box[] boxPerm = new Box[input.length * 3];
        createBoxPermutations(input, boxPerm);
        int maxHeight = 0;
        Arrays.sort(boxPerm, (o1, o2) -> o2.l * o2.w - o1.l * o1.w); // sort in descending order
        int[] dp = new int[boxPerm.length];
        dp[0] = boxPerm[0].h;
        for (int i = 1; i < boxPerm.length; i++) {
            dp[i] = boxPerm[i].h;
            for (int j = 0; j < i; j++) { // check if i can be placed on top of j; since input is sorted in descending order
                if (boxPerm[i].l < boxPerm[j].l && boxPerm[i].w < boxPerm[j].w) {
                    dp[i] = Math.max(dp[i], dp[j] + boxPerm[i].h); // max height at j + height of boxPerm[j]
                }
                maxHeight = Math.max(maxHeight, dp[i]);
            }
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        Box input[] = {new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6),
                new Box(10, 12, 32)};
        System.out.println(new BoxStacking().maxHeight(input));
    }

}
