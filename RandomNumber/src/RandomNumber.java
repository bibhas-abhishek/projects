import java.util.Calendar;
import java.util.Scanner;

class RandomNumber {

    static long seed = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        long r = randomNumber(n);
        scan.close();
        System.out.println(r);
    }

    static private long randomNumber(int n) {
        Calendar calendar = Calendar.getInstance();
        long randomNumber = 0;
        long m = calendar.getTimeInMillis() + calendar.get(Calendar.SECOND)
                + (60 * calendar.get(Calendar.MINUTE))
                + (3600 * calendar.get(Calendar.HOUR));
        if (seed == 0) {
            seed = m;
        }
        randomNumber = (m + seed) % n;
        return randomNumber;
    }

}