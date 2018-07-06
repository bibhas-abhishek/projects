import java.text.ParseException;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */

public class TestBed {

    public static void main(String[] args) throws ParseException {
        String dateTime = "2018-05-18T19:47:59.397";
        System.out.println(dateTime.substring(0, dateTime.indexOf("T")));
        System.out.println(dateTime.substring(dateTime.indexOf("T") + 1, dateTime.indexOf(".")));
    }

}
