import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBoggle {

    private static final Set<String> dictionary = new HashSet<>(Arrays.asList("GEEKS", "FOR", "QUIZ", "GO"));

    private void findWords(char[][] boggle) {
        int row = boggle.length;
        int col = boggle[0].length;
        boolean[][] visited = new boolean[row][col];
        String word = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                findWordsUtil(i, j, boggle, visited, word);
            }
        }
    }

    private void findWordsUtil(int i, int j, char[][] boggle, boolean[][] visited, String word) {
        visited[i][j] = true;
        word = word + boggle[i][j];
        if (dictionary.contains(word)) {
            System.out.println(word);
        }

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nextRow = i + dr;
                int nextCol = j + dc;
                if (nextRow >= 0 && nextRow < boggle.length
                        && nextCol >= 0
                        && nextCol < boggle[0].length
                        && !visited[nextRow][nextCol]) {
                    findWordsUtil(nextRow, nextCol, boggle, visited, word);
                }
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] boggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
        new WordBoggle().findWords(boggle);
    }
}
