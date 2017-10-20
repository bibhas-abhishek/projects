import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 20 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TimeConversion
 * https://www.hackerrank.com/challenges/time-conversion/problem
 */
public class TimeConversion {

    private static String timeConversion(String s) {
        String time = s.substring(0, s.length() - 2);
        String meridiem = s.substring(s.length() - 2);
        int hour = Integer.parseInt(time.substring(0, 2));
        StringBuilder result = new StringBuilder();
        switch (meridiem) {
            case "AM":
                result.append(0).append(hour % 12).append(time.substring(2));
                break;
            case "PM":
                result.append((hour % 12) + 12).append(time.substring(2));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }

}
