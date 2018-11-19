/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 20 Nov 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MaxNumberKSwaps
 */

public class MaxNumberKSwaps {

    private static String max;

    private void swap(char[] num, int i, int j) {
        char c = num[i];
        num[i] = num[j];
        num[j] = c;
    }

    public void findMaxNumber(char[] num, int n, int k) {
        if (k == 0)
            return;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (num[j] > num[i]) {
                    swap(num, i, j);
                    String t = new String(num);
                    if (max.compareTo(t) < 0)
                        max = t;

                    findMaxNumber(num, n, k - 1);
                    swap(num, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        String num = "129814999";
        int k = 4;
        max = num;
        new MaxNumberKSwaps().findMaxNumber(num.toCharArray(), num.length(), k);
        System.out.println(max);
    }

}
