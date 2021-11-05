import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {

    public List<String> permute(char[] input) {
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

    private void permuteString(char[] str, int[] count, char[] result, int index,
                               List<String> resultList) {
        if (index == result.length) {
            resultList.add(new String(result));
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (count[i] != 0) {
                result[index] = str[i];
                count[i] -= 1;
                permuteString(str, count, result, index + 1, resultList);
                count[i] += 1;
            }
        }
    }

    public static void main(String[] args) {
        String input = "AABC";
        StringPermutation driver = new StringPermutation();
        System.out.println(driver.permute(input.toCharArray()));
    }
}
