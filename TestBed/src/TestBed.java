import java.text.ParseException;

/**
 * Bibhas Abhishek bibhas_01@hotmail.com 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */

public class TestBed {

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFromZeroDay(date1) - daysFromZeroDay(date2));
    }

    private int daysFromZeroDay(String date) {
        int[] monthDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] data = date.split("-");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);
        for (int i = 1971; i < year; i++) {
            day += isLeapYear(i) ? 366 : 365;
        }

        for (int i = 1; i < month; i++) {
            if (isLeapYear(year) && i == 2) {
                day += 1;
            }
            day += monthDays[i];
        }
        return day;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) throws ParseException {
        String date1 = "2019-06-29", date2 = "2019-06-30";
        System.out.println(new TestBed().daysBetweenDates(date1, date2));
    }
}
