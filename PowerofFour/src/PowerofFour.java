/**
 * Bibhas Abhishek
 * bibhas.abhishek@ril.com
 * 08 Jun 2018
 * PowerofFour: Copyright JioMoney 2018
 **/

public class PowerofFour {

    private static boolean isPowerOfFour(int num) {
        return ((num - 1) & num) == 0 && (num - 1) % 3 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(4));
    }

}
