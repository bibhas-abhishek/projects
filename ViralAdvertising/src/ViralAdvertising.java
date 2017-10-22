import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/ViralAdvertising
 * https://www.hackerrank.com/challenges/strange-advertising/problem
 */
public class ViralAdvertising {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(viralAdvertising(n, 1, 5));
    }

    private static int viralAdvertising(int n, int count, int totalPeople) {
        if (count > n)
            return 0;
        else
            return totalPeople / 2 + viralAdvertising(n, count + 1, totalPeople / 2 * 3);
    }

}
