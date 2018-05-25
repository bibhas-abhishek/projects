import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    private static List<String> findRepeatedDnaSequences(String s) {
        Set<String> hashSet = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (hashSet.contains(str))
                result.add(str);
            else
                hashSet.add(str);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

}
