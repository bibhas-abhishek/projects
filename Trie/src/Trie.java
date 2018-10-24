import java.util.*;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 02 Oct 2018
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
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

    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(TrieNode node, String word, int index) {
        if (index == word.length()) {
            node.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode childNode = node.children.get(ch);
        if (childNode == null) {
            childNode = new TrieNode();
            node.children.put(ch, childNode);
        }
        childNode.visited += 1;
        insert(childNode, word, index + 1);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int index) {
        if (index == word.length())
            return node.endOfWord;

        char ch = word.charAt(index);
        TrieNode childNode = node.children.get(ch);
        if (childNode == null)
            return false;

        return search(childNode, word, index + 1);
    }

    public int countPartial(String word) {
        return countPartial(root, word, 0);
    }

    private int countPartial(TrieNode node, String word, int index) {
        if (node == null)
            return 0;

        char ch = word.charAt(index);
        TrieNode childNode = node.children.get(ch);
        if (childNode == null)
            return 0;

        if (index == word.length() - 1)
            return childNode.visited;

        return countPartial(childNode, word, index + 1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(TrieNode node, String word, int index) {
        if (index == word.length())
            return true;

        char ch = word.charAt(index);
        TrieNode child = node.children.get(ch);
        if (child == null)
            return false;

        return startsWith(child, word, index + 1);
    }

    public boolean searchPattern(String word) {
        return searchPattern(root, word, 0);
    }

    private boolean searchPattern(TrieNode node, String word, int index) {
        if (index == word.length())
            return node.endOfWord;

        char ch = word.charAt(index);
        TrieNode child = node.children.get(ch);
        if (word.charAt(index) == '.') {
            for (Character c : node.children.keySet()) {
                if (searchPattern(node.children.get(c), word, index + 1))
                    return true;
            }
        }

        if (child == null)
            return false;

        return searchPattern(child, word, index + 1);
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (!node.endOfWord) {
                return false;
            }
            node.endOfWord = false;
            return node.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode childNode = node.children.get(ch);
        if (childNode == null) {
            return false;
        }

        if (delete(childNode, word, index + 1)) {
            node.children.remove(ch);
            return node.children.size() == 0;
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
                    insert(value);
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

        trie.insert("hack");
        /*trie.insert("hacker");
        trie.insert("hackerrank");
        trie.insert("hacked");*/

        System.out.println("hack: " + trie.search("hack"));
        System.out.println("hacker: " + trie.search("hacker"));
        System.out.println("hac: " + trie.search("hac"));
        System.out.println("hacked: " + trie.search("hacked"));

        trie.delete("hacker");
        System.out.println("hacker: " + trie.search("hacker"));
        System.out.println("startsWith: " + trie.startsWith("hacks"));
        System.out.println("hasPattern: " + trie.searchPattern("h..k"));
    }

}
