/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RabinKarp
 **/

public class RabinKarp {

    private static int prime = 37;

    private static long createHash(char[] str, int len) {
        long hash = 0;
        for (int i = 0; i < len; i++)
            hash += str[i] * Math.pow(prime, i);
        return hash;
    }

    /**
     * @param str
     * @param oldIndex -> start index of old pattern
     * @param newIndex -> end index of new pattern
     * @param oldHash
     * @param len      -> full length of pattern
     * @return
     */
    private static long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int len) {
        long newHash = oldHash - str[oldIndex];
        newHash /= prime;
        newHash += str[newIndex] * Math.pow(prime, len - 1);
        return newHash;
    }

    private static boolean ifEquals(char[] text, char[] pattern, int len, int offset) {
        int i = 0;
        while (i < len) {
            if (text[i + offset] != pattern[i])
                return false;
            i++;
        }
        return true;
    }

    private static int contains(char[] text, char[] pattern) {
        int textLength = text.length;
        int patternLength = pattern.length;
        if ((textLength == 0 && patternLength == 0) || (patternLength == 0 && textLength != 0))
            return 0;

        if (textLength == 0 || patternLength == 0 || patternLength > textLength)
            return -1;

        long patternHash = createHash(pattern, patternLength);
        long textHash = createHash(text, patternLength);
        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && ifEquals(text, pattern, patternLength, i))
                return i;
            if (i + patternLength < text.length)
                textHash = recalculateHash(text, i, i + patternLength, textHash, patternLength);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(contains("ABCDEFXYZ".toCharArray(), "CDE".toCharArray()));
    }

}
