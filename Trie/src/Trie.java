import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 02 Oct 2018
 * https://www.hackerrank.com/challenges/contacts/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/Trie
 */

public class Trie {

    private class TrieNode {

        Map<Character, TrieNode> children;
        boolean endOfWord;
        int visited;

        TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }

    }

    private TrieNode root = new TrieNode();

    private void insertWord(String word) {
        insertWord(root, word, 0);
    }

    private void insertWord(TrieNode root, String word, int index) {
        if (index == word.length()) {
            root.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode childNode = root.children.get(ch);
        if (childNode == null) {
            childNode = new TrieNode();
            root.children.put(ch, childNode);
        }

        childNode.visited += 1;
        insertWord(childNode, word, index + 1);
    }

    private boolean searchComplete(String word) {
        return searchComplete(root, word, 0);
    }

    private boolean searchComplete(TrieNode currentNode, String word, int index) {
        if (index == word.length())
            return currentNode.endOfWord;

        char ch = word.charAt(index);
        TrieNode childNode = currentNode.children.get(ch);
        if (childNode == null)
            return false;

        return searchComplete(childNode, word, index + 1);
    }

    private int countPartial(String word) {
        return countPartial(root, word, 0);
    }

    private int countPartial(TrieNode current, String word, int index) {
        if (current == null)
            return 0;

        char ch = word.charAt(index);
        TrieNode childNode = current.children.get(ch);
        if (childNode == null)
            return 0;

        if (index == word.length() - 1)
            return childNode.visited;

        return countPartial(childNode, word, index + 1);
    }

    private void deleteWord(String word) {
        deleteWord(root, word, 0);
    }

    private boolean deleteWord(TrieNode root, String word, int index) {
        if (index == word.length()) {
            if (!root.endOfWord) {
                return false;
            }
            root.endOfWord = false;
            return root.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode childNode = root.children.get(ch);
        if (childNode == null) {
            return false;
        }

        if (deleteWord(childNode, word, index + 1)) {
            root.children.remove(ch);
            return root.children.size() == 0;
        }
        return false;
    }

    // Hackerrank
    private int[] contacts(String[][] queries) {
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

    public static void main(String[] args) {
        /*
        String[][] queries = {{"add", "hack"}, {"add", "hackerrank"}, {"find", "hac"}, {"find", "hak"}, {"add", "hacked"}};
        Arrays.stream(contacts(queries)).forEach(System.out::println);
        */

        Trie trie = new Trie();

        trie.insertWord("hack");
        trie.insertWord("hacker");
        trie.insertWord("hackerrank");
        trie.insertWord("hacked");

        System.out.println("hack: " + trie.searchComplete("hack"));
        System.out.println("hacker: " + trie.searchComplete("hacker"));
        System.out.println("hac: " + trie.searchComplete("hac"));
        System.out.println("hacked: " + trie.searchComplete("hacked"));

        trie.deleteWord("hacker");
        System.out.println("hacker: " + trie.searchComplete("hacker"));
    }

}
