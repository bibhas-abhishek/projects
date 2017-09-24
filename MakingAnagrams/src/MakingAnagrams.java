import java.util.Scanner;

public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {
        int[] freq = new int['z' - 'a' + 1];
        int i;
        for (i = 0; i < first.length(); i++)
            freq[first.charAt(i) - 'a']++;
        for (i = 0; i < second.length(); i++)
            freq[second.charAt(i) - 'a']--;
        int numberNeeded = 0;
        for (i = 0; i < freq.length; i++)
            numberNeeded += Math.abs(freq[i]);

        return numberNeeded;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

}
