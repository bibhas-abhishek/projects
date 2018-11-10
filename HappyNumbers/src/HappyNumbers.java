import java.util.HashSet;
import java.util.Set;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 08 Nov 2018
 * https://leetcode.com/problems/happy-number/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/HappyNumbers
 */

public class HappyNumbers {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int d = 0;
            while (n != 0) {
                int m = n % 10;
                n /= 10;
                d += m * m;
            }
            n = d;
            if (!set.add(d))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumbers().isHappy(19));
    }

}
