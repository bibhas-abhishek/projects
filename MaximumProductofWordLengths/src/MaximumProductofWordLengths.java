/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Jun 2018
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumProductofWordLengths
 **/

public class MaximumProductofWordLengths {

    private static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        int[] encode = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++)
                encode[i] |= 1 << (word.charAt(j) - 'a');
        }

        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((encode[i] & encode[j]) == 0)
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(words));
    }

}
