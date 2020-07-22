import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 */

public class Trie {

    public static class TrieNode {

        Map<Character, TrieNode> children;
        boolean                  endOfWord;

        TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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
        insert(childNode, word, index + 1);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.endOfWord;
        }

        char ch = word.charAt(index);
        TrieNode childNode = node.children.get(ch);
        if (childNode == null) {
            return false;
        }
        return search(childNode, word, index + 1);
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

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hack");
        trie.insert("hacker");
        trie.insert("hackerrank");
        trie.insert("hacked");
        System.out.println("hack: " + trie.search("hack"));
        System.out.println("hacker: " + trie.search("hacker"));
        System.out.println("hac: " + trie.search("hac"));
        System.out.println("hacked: " + trie.search("hacked"));
        trie.delete("hacker");
        System.out.println("hacker: " + trie.search("hacker"));
    }
}
