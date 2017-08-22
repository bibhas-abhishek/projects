import java.util.LinkedHashMap;
import java.util.Map;

public class RunLengthEncoding {
    public static void main(String[] args) {
        if (args.length < 1)
            return;
        String encode = args[0];
        String retValue = encodeFn(encode);
        System.out.print(retValue);
    }

    private static String encodeFn(String encode) {
        Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();
        for (int i = 0; i < encode.length(); i++) {
            char key = encode.charAt(i);
            if (!characterIntegerMap.containsKey(key))
                characterIntegerMap.put(key, 1);
            else
                characterIntegerMap.put(key, characterIntegerMap.get(key) + 1);
        }

        StringBuilder builder = new StringBuilder();
        for (Character c : characterIntegerMap.keySet())
            builder.append(c).append(characterIntegerMap.get(c));

        return builder.toString();
    }

}
