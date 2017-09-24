import java.util.Scanner;

public class MatrixEncryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        matrixEncrypt(s);
    }

    private static void matrixEncrypt(String s) {
        int x = (int) Math.round(Math.sqrt(s.length()));
        int y = x >= Math.sqrt(s.length()) ? x : x + 1;
        char matrix[][] = new char[x][y];
        int i = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (i < s.length() && s.charAt(i) != ' ')
                    matrix[row][col] = s.charAt(i);
                i++;
            }
        }

        //PrintOut
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] != 0)
                    System.out.print(matrix[row][col]);
            }
            System.out.print(" ");
        }
    }

}
