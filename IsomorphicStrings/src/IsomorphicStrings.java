/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 19 Apr 2018
 * https://leetcode.com/problems/isomorphic-strings/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/IsomorphicStrings
 **/

public class IsomorphicStrings {

    private static boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (getFirstIndex(s, i) != getFirstIndex(t, i))
                return false;
        }
        return true;
    }

    private static int getFirstIndex(String str, int index) {
        char ch = str.charAt(index);

        //now get the first index of this character
        int firstIndex = str.indexOf(ch);
        if (firstIndex < index)
            return firstIndex;
        return index;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

}
