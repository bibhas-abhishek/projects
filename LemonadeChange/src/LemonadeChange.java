/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 20 Sep 2018
 * https://leetcode.com/problems/lemonade-change/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LemonadeChange
 */

public class LemonadeChange {

    private static boolean lemonadeChange(int[] bills) {
        int fiveCount = 0, tenCount = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fiveCount += 1;
                    break;
                case 10:
                    if (fiveCount > 0) {
                        fiveCount -= 1;
                        tenCount += 1;
                    } else
                        return false;
                    break;
                case 20:
                    if (tenCount > 0 && fiveCount > 0) {
                        fiveCount -= 1;
                        tenCount -= 1;
                    } else if (fiveCount > 2) {
                        fiveCount -= 3;
                    } else
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(arr));
    }

}
