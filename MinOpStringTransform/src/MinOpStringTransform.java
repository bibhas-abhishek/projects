/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MinOpStringTransform
 */

public class MinOpStringTransform {

    public int minOps(String a, String b) {
        if (a.length() != b.length())
            return -1;

        int[] count = new int[1 << 8];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)] += 1;
            count[b.charAt(i)] -= 1;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                return -1;
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int result = 0;
        while (i >= 0) {
            if (a.charAt(i) != b.charAt(j))
                result += 1;
            else
                j -= 1;
            i -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "EACBD";
        String b = "EABCD";
        MinOpStringTransform obj = new MinOpStringTransform();
        System.out.println(obj.minOps(a, b));
    }

}
