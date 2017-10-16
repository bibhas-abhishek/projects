import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--)
                System.out.print(j <= i ? "#" : " ");

            System.out.println();
        }
    }

}
