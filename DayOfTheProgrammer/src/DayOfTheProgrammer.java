import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/DayOfTheProgrammer
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */
public class DayOfTheProgrammer {

    static String solve(int year) {
        final int month7Days = 215;
        int febDays;
        if (year < 1918)
            febDays = (year % 4 == 0 ? 29 : 28);
        else if (year > 1918)
            febDays = (year % 400 == 0
                    || (year % 4 == 0 && year % 100 != 0)
                    ? 29 : 28);
        else //year 1918
            febDays = 15;
        return (256 - 215 - febDays) + ".09" + "." + year;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }

}
