/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RabinKarp
 **/

public class RabinKarp {

    private static int prime = 37;

    private long createHash(char[] str, int len) {
        long hash = 0;
        for (int i = 0; i < len; i++)
            hash += str[i] * Math.pow(prime, i);

        return hash;
    }

    private long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int len) {
        long newHash = oldHash - str[oldIndex];
        newHash /= prime;
        newHash += str[newIndex] * Math.pow(prime, len - 1);
        return newHash;
    }

    private boolean matches(char[] text, char[] pattern, int len, int offset) {
        int i = 0;
        while (i < len) {
            if (text[i + offset] != pattern[i])
                return false;
            i++;
        }
        return true;
    }

    public int contains(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0)
            return 0;

        if (n == 0 || m > n)
            return -1;

        long patternHash = createHash(pattern, m);
        long textHash = createHash(text, m);
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && matches(text, pattern, m, i))
                return i;

            if (i + m < text.length)
                textHash = recalculateHash(text, i, i + m, textHash, m);
        }
        return -1;
    }

    public static void main(String[] args) {
        RabinKarp obj = new RabinKarp();
        String text = "ABCDEFXYZ";
        String pattern = "CDE";
        System.out.println(obj.contains(text.toCharArray(), pattern.toCharArray()));
    }

}
