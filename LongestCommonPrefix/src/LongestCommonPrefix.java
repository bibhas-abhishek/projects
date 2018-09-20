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
        int visited;

        public TrieNode() {
            childMap = new HashMap<>();
            endOfWord = false;
            visited = 0;
        }

    }

    private static TrieNode root = new TrieNode();

    private static String findLongestPrefixTrie(TrieNode current, StringBuilder builder) {
        if (current == null)
            return null;

        if (current.endOfWord)
            return builder.toString();

        Map<Character, TrieNode> childMap = current.childMap;
        char ch = ' ';
        if (childMap != null) {
            if (childMap.size() == 1) {
                for (Map.Entry<Character, TrieNode> entry : childMap.entrySet()) {
                    ch = entry.getKey();
                    builder.append(ch);
                }
            } else
                return builder.toString();
        }
        return findLongestPrefixTrie(current.childMap.get(ch), builder);
    }

    private static String solveDivideConquer(String[] array, int low, int high) {
        if (low == high)
            return array[low];

        if (low < high) {
            int mid = (low + high) / 2;
            String s1 = solveDivideConquer(array, low, mid);
            String s2 = solveDivideConquer(array, mid + 1, high);
            return checkMatch(s1, s2);
        }
        return null;
    }

    private static String checkMatch(String s1, String s2) {
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

    private static void insertWord(String word) {
        insertWord(root, word, 0);
    }

    private static void insertWord(TrieNode currentNode, String word, int index) {
        if (index == word.length()) {
            currentNode.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode childNode = currentNode.childMap.get(ch); // take out child trieNode from the parent childMap
        if (childNode == null) {
            childNode = new TrieNode();
            currentNode.childMap.put(ch, childNode);
        }
        childNode.visited += 1;
        insertWord(childNode, word, index + 1);
    }

    public static void main(String[] args) {
        String array[] = {"geeksforgeeks", "geeks", "geek", "geezer", "ge"};
        System.out.println(solveDivideConquer(array, 0, array.length - 1));

        Arrays.stream(array).forEach(LongestCommonPrefix::insertWord);
        System.out.println(findLongestPrefixTrie(root, new StringBuilder()));

    }

}
