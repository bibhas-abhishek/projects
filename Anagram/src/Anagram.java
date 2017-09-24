import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
    }

    private static int anagram(String s) {
        if (s.length() % 2 != 0)
            return -1;
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2, s.length());
        int freq[] = new int['z' - 'a' + 1];
        int i;
        for (i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;
        for (i = 0; i < s2.length(); i++)
            freq[s2.charAt(i) - 'a']--;
        int count = 0;
        for (i = 0; i < freq.length; i++)
            count += Math.abs(freq[i]);
        return count / 2;
    }

}
