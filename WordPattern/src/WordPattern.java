/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 19 Apr 2018
 * https://leetcode.com/problems/word-pattern/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/WordPattern
 **/

public class WordPattern {

    private static boolean wordPattern(String pattern, String str) {
        String[] arr = str.split("\\s+");
        if (pattern.length() != arr.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (getFirstIndexString(pattern, i) != getFirstIndexArray(arr, i))
                return false;
        }
        return true;
    }

    private static int getFirstIndexString(String str, int index) {
        char ch = str.charAt(index);
        int firstIndex = str.indexOf(ch);
        if (firstIndex < index)
            return firstIndex;
        return index;
    }

    private static int getFirstIndexArray(String[] arr, int index) {
        String str = arr[index];
        int firstIndex = getFirstMatch(arr, str);
        if (firstIndex < index)
            return firstIndex;
        return index;
    }

    private static int getFirstMatch(String[] source, String target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(target))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat fish";
        System.out.println(wordPattern(pattern, str));
    }

}
