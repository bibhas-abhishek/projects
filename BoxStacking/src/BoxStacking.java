import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BoxStacking
 */

public class BoxStacking {

    private static class Box {

        int l;
        int w;
        int h;

        public Box() {
        }

        public Box(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
        }

        private static Box createBox(int d1, int d2, int d3) {
            Box b = new Box();
            b.h = d3;
            if (d1 >= d2) {
                b.l = d1;
                b.w = d2;
            } else {
                b.l = d2;
                b.w = d1;
            }
            return b;
        }

        private static void createBoxPermutations(Box[] input, Box[] boxPerm) {
            int index = 0;
            for (int i = 0; i < input.length; i++) {
                boxPerm[index++] = createBox(input[i].h, input[i].w, input[i].l);
                boxPerm[index++] = createBox(input[i].l, input[i].h, input[i].w);
                boxPerm[index++] = createBox(input[i].l, input[i].w, input[i].h);
            }
        }

        private static int maxHeight(Box[] input) {
            Box[] boxPerm = new Box[input.length * 3];
            createBoxPermutations(input, boxPerm);
            int maxHeight = 0;
            Arrays.sort(boxPerm, (o1, o2) -> o2.l * o2.w - o1.l * o1.w);
            int[] dp = new int[boxPerm.length];
            for (int i = 0; i < boxPerm.length; i++)
                dp[i] = boxPerm[i].h;

            for (int i = 1; i < boxPerm.length; i++) {
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
            Box input[] = {new Box(3, 2, 5), new Box(1, 2, 4)};
            System.out.println(maxHeight(input));

        }

    }

}
