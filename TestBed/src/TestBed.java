import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    public static void main(String[] args) {
        System.out.println(rotateString("aa", "a"));
    }

    public static boolean rotateString(String A, String B) {
        if (A.length() == B.length() && (B + B).contains(A))
            return true;
        return false;
    }

}
