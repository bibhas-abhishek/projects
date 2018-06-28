import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 12 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/StringPermutation
 **/

public class StringPermutation {

    private static List<String> permute(char[] input) {
        Map<Character, Integer> treeMap = new TreeMap<>();
        for (char ch : input) {
            treeMap.compute(ch, (key, val) -> {
                if (val == null)
                    return 1;
                else
                    return val + 1;
            });
        }

        char[] str = new char[treeMap.size()];
        int[] count = new int[treeMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index += 1;
        }

        List<String> resultList = new ArrayList<>();
        char[] result = new char[input.length];
        permuteString(str, count, result, 0, resultList);
        return resultList;
    }

    private static void permuteString(char[] str, int[] count, char[] result, int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (count[i] == 0)
                continue;

            result[level] = str[i];
            count[i] -= 1;
            permuteString(str, count, result, level + 1, resultList);
            count[i] += 1;
        }
    }

    public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
        String input = "AABC";
        permute(input.toCharArray()).stream().map(str -> str + " ").forEach(System.out::print);
    }

}
