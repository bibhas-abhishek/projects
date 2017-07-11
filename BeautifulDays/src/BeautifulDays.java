/**
 * Created by bibhas on 09/07/17.
 */
import java.util.Scanner;

public class BeautifulDays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int beautifulDays = 0;

        for(int c = i; c <= j; ++c) {
            if(Math.abs(c - reverse(c)) % k == 0) {
                ++beautifulDays;
            }
        }
        System.out.print(beautifulDays);
    }

    public static int reverse(int n) {
        int reverse;
        for(reverse = 0; n != 0; n /= 10) {
            reverse = 10 * reverse + n % 10;
        }
        return reverse;
    }

}

