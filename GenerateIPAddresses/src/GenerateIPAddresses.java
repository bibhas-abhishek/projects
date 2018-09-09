import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Sep 2018
 * https://www.geeksforgeeks.org/program-to-validate-an-ip-address/
 * https://github.com/bibhas-abhishek/projects/tree/master/GenerateIPAddresses
 */

public class GenerateIPAddresses {

    public static List<String> restoreIpAddresses(String ipString) {
        if (ipString.length() < 3 || ipString.length() > 12)
            return new ArrayList<>();
        return convert(ipString);
    }

    private static List<String> convert(String s) {
        List<String> result = new ArrayList<>();
        int size = s.length();
        String sNew = s;
        for (int i = 1; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    sNew = sNew.substring(0, k) + "." + sNew.substring(k);
                    sNew = sNew.substring(0, j) + "." + sNew.substring(j);
                    sNew = sNew.substring(0, i) + "." + sNew.substring(i);
                    if (isValid(sNew))
                        result.add(sNew);
                    sNew = s;
                }
            }
        }
        return result;
    }

    private static boolean isValid(String ip) {
        String a[] = ip.split("[.]");
        for (String s : a) {
            int i = Integer.parseInt(s);
            if (s.length() > 3 || i < 0 || i > 255)
                return false;
            if (s.length() > 1 && i == 0)
                return false;
            if (s.length() > 1 && i != 0 && s.charAt(0) == '0')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135").toString());
    }

}
