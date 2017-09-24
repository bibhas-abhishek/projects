import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CountTheBirds {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int TEST = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < TEST; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] T = new int[N];
            int i;
            String[] input_0 = br.readLine().trim().split(" ");
            for (i = 0; i < N; i++) {
                T[i] = Integer.parseInt(input_0[i]);
            }
            int Q = Integer.parseInt(br.readLine().trim());
            int q = Q;
            while (q > 0) {
                String[] input_1 = br.readLine().trim().split(" ");
                int X = Integer.parseInt(input_1[0]);
                int Y = Integer.parseInt(input_1[1]);
                boolean[] flag = new boolean[N];
                int seenCount = 0;
                int j;
                for (j = 0; j < flag.length; j++)
                    flag[j] = false;
                for (i = X; i <= Y; i++) {
                    for (j = 0; j < T.length; j++) {
                        if (!flag[j] && i % T[j] == 0) {
                            flag[j] = true;
                            seenCount++;
                        }
                    }
                }
                System.out.println(seenCount);
                q--;
            }
        }

        wr.close();
        br.close();
    }

}
