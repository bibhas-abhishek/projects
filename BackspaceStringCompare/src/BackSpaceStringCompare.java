/**
 * Bibhas Abhishek
 * bibhas.abhishek@ril.com
 * 06 Jun 2018
 * BackspaceStringCompare: Copyright JioMoney 2018
 **/

public class BackSpaceStringCompare {

    private static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, skipS = 0, skipT = 0;

        // find next comparable character not cancelled out a successive #
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS += 1;
                    i -= 1;
                } else if (skipS > 0) {
                    skipS -= 1;
                    i -= 1;
                } else
                    break;
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT += 1;
                    j -= 1;
                } else if (skipT > 0) {
                    skipT -= 1;
                    j -= 1;
                } else
                    break;
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;

            if (i >= 0 != j >= 0)
                return false;

            i -= 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }

}
