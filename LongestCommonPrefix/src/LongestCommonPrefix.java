import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Apr 2018
 * https://leetcode.com/problems/longest-common-prefix/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestCommonPrefix
 **/

public class LongestCommonPrefix {

    private static class TrieNode {

        Map<Character, TrieNode> childMap;
        boolean endOfWord;

        public TrieNode() {
            childMap = new HashMap<>();
            endOfWord = false;
        }

    }

    private static TrieNode root = new TrieNode();

    public void insertWord(String word) {
        insertWord(root, word, 0);
    }

    private void insertWord(TrieNode node, String word, int index) {
        if (index == word.length()) {
            node.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode childNode = node.childMap.get(ch); // take out child trieNode from the parent childMap
        if (childNode == null) {
            childNode = new TrieNode();
            node.childMap.put(ch, childNode);
        }
        insertWord(childNode, word, index + 1);
    }

    private String solveTrie(TrieNode root, StringBuilder builder) {
        if (root == null)
            return null;

        if (root.endOfWord)
            return builder.toString();

        char ch;
        Map<Character, TrieNode> childMap = root.childMap;
        if (childMap != null && childMap.size() == 1) {
            ch = childMap.keySet().stream().findFirst().get();
            builder.append(ch);
        } else
            return builder.toString();

        TrieNode childNode = root.childMap.get(ch);
        return solveTrie(childNode, builder);
    }

    public String solveDivideNConquer(String[] array, int low, int high) {
        if (low == high)
            return array[low];

        if (low < high) {
            int mid = (low + high) / 2;
            String s1 = solveDivideNConquer(array, low, mid);
            String s2 = solveDivideNConquer(array, mid + 1, high);
            return checkMatch(s1, s2);
        }
        return null;
    }

    private String checkMatch(String s1, String s2) {
        int i = 0, j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j))
                stringBuilder.append(s1.charAt(i));
            else
                break;
            i++;
            j++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String array[] = {"geeksforgeeks", "geeks", "geek", "geezer", "gee"};
        System.out.println(obj.solveDivideNConquer(array, 0, array.length - 1));

        Arrays.stream(array).forEach(obj::insertWord);
        System.out.println(obj.solveTrie(root, new StringBuilder()));

    }

}
