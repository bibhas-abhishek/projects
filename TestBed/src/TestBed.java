import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        leftRotation(a, 4);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.print(reverse(321));
    }

    private static int[] leftRotation(int[] a, int d) {
        for (int i = 0; i < d; i++)
            a = leftRotateByOne(a);
        return a;
    }

    private static int[] leftRotateByOne(int[] a) {
        int temp = a[0];
        for (int i = 0; i < a.length - 1; i++)
            a[i] = a[i + 1];
        a[a.length - 1] = temp;
        return a;
    }

    private static int reverse(int x) {
        int reverse = 0;
        int temp = 0;
        while (x != 0) {
            int mod = x % 10;
            temp = reverse * 10 + mod;
            if ((temp - mod) / 10 != reverse)
                return 0;
            reverse = temp;
            x = x / 10;
        }

        return reverse;
    }

}
