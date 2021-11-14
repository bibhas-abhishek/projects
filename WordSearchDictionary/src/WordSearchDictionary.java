/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: WordSearchDictionary
*- 14 Nov 2021 2:46 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/word-search-ii
-------------------------------------------*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchDictionary {

    private class TrieNode {
        Map<Character, TrieNode> child;
        boolean                  word;

        TrieNode() {
            child = new HashMap<>();
            word = false;
        }
    }

    TrieNode root = new TrieNode();

    private void buildTrie(String[] words) {
        for (String word : words) {
            insertTrie(word, root, 0);
        }
    }

    private void insertTrie(String word, TrieNode root, int index) {
        if (index == word.length()) {
            root.word = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode node = root.child.get(ch);
        if (node == null) {
            node = new TrieNode();
            root.child.put(ch, node);
        }
        insertTrie(word, node, index + 1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;
        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (root.child.get(board[i][j]) != null) {
                    wordSearch(i, j, board, new StringBuilder(), visited, root, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void wordSearch(int r, int c, char[][] board, StringBuilder sb, boolean[][] visited,
                            TrieNode root, Set<String> result) {
        if (root.word) {
            result.add(sb.toString());
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]
            || root.child.get(board[r][c]) == null) {
            return;
        }

        visited[r][c] = true;
        int[] moveX = { 1, 0, 0, -1 };
        int[] moveY = { 0, 1, -1, 0 };
        sb.append(board[r][c]);
        for (int i = 0; i < moveX.length; i++) {
            int nextX = r + moveX[i];
            int nextY = c + moveY[i];
            TrieNode child = root.child.get(board[r][c]);
            wordSearch(nextX, nextY, board, sb, visited, child, result);
        }
        visited[r][c] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                           { 'i', 'f', 'l', 'v' } };
        String[] words = { "oath", "dig", "dog", "dogs" };
        WordSearchDictionary driver = new WordSearchDictionary();
        System.out.println(driver.findWords(board, words));
    }
}
