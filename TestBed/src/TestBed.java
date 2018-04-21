/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    private static String reverseString(String s) {
        char[] strArray = reverseString(s.toCharArray(), 0, s.length() - 1);
        return new String(strArray);
    }

    private static char[] reverseString(char[] strArray, int i, int j) {
        if (i >= j)
            return strArray;

        swap(strArray, i, j);
        return reverseString(strArray, i + 1, j - 1);
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcxyz"));
    }

}
