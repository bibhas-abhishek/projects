/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Jan 2018
 * https://leetcode.com/problems/compare-version-numbers/
 * https://github.com/bibhas-abhishek/projects/tree/master/CompareVersionNumbers/
 **/

public class CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.print(compare("1.1", "1.0"));
    }

    private static int compareVersion(String version1, String version2) {
        return compare(version1, version2);
    }

    private static int compare(String s0, String s1) {
        String[] version1 = s0.split("\\.");
        String[] version2 = s1.split("\\.");
        for (int i = 0; i < Math.max(version1.length, version2.length); i++) {
            int num1 = (i < version1.length) ? Integer.parseInt(version1[i]) : 0;
            int num2 = (i < version2.length) ? Integer.parseInt(version2[i]) : 0;
            if (num1 < num2)
                return -1;
            else if (num2 < num1)
                return 1;
        }
        return 0;
    }

}
