import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        int wordLength = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                char[] word = queue.poll().toCharArray();
                for (int i = 0; i < word.length; i++) {
                    char savedPos = word[i];
                    for (char pos = 'a'; pos <= 'z'; pos++) {
                        word[i] = pos;
                        String transform = String.valueOf(word);
                        if (transform.equals(endWord)) {
                            return wordLength + 1;
                        }

                        if (!dict.contains(transform)) {
                            continue;
                        }

                        queue.offer(transform);
                        dict.remove(transform);
                    }
                    word[i] = savedPos;
                }
                size -= 1;
                wordLength += 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = Arrays.asList("a", "b", "c");
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
    }
}
