import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 08 Apr 2018
 * https://www.hackerrank.com/challenges/contacts/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/TrieOperations
 **/
public class TrieOperations {

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

    public static void main(String[] args) {
        String[][] queries = {{"add", "hack"}, {"add", "hackerrank"}, {"find", "hac"}, {"find", "hak"}, {"add", "hacked"}};
        for (int i : contacts(queries))
            System.out.println(i);

        System.out.println(searchComplete("hack"));
        System.out.println(searchComplete("hacker"));
        System.out.println(searchComplete("hacked"));
        deleteWord("hacked");
        System.out.println(searchComplete("hacked"));
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

    private static boolean searchComplete(String word) {
        return searchComplete(root, word, 0);
    }

    private static boolean searchComplete(TrieNode currentNode, String word, int index) {
        if (index == word.length())
            return currentNode.endOfWord;

        char ch = word.charAt(index);
        TrieNode childNode = currentNode.childMap.get(ch);
        if (childNode == null)
            return false;

        return searchComplete(childNode, word, index + 1);
    }

    private static int countPartial(String word) {
        return countPartial(root, word, 0);
    }

    private static int countPartial(TrieNode current, String word, int index) {
        if (current == null)
            return 0;
        char ch = word.charAt(index);
        TrieNode childNode = current.childMap.get(ch);
        if (childNode == null)
            return 0;
        if (index == word.length() - 1)
            return childNode.visited;
        return countPartial(childNode, word, index + 1);
    }

    // hackerrank code
    private static int[] contacts(String[][] queries) {
        List<Integer> result = new ArrayList<>();
        for (String[] query : queries) {
            String operation = query[0];
            String value = query[queries[0].length - 1];
            switch (operation) {
                case "add":
                    insertWord(value);
                    break;
                case "find":
                    result.add(countPartial(value));
                    break;
            }
        }

        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            output[i] = result.get(i);
        return output;
    }

    private static void deleteWord(String word) {
        deleteWord(root, word, 0);
    }

    private static boolean deleteWord(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            return current.childMap.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode childNode = current.childMap.get(ch);
        if (childNode == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = deleteWord(childNode, word, index + 1);
        if (shouldDeleteCurrentNode) {
            current.childMap.remove(ch);
            return current.childMap.size() == 0;
        }
        return false;
    }

}
