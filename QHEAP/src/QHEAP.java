import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 21 Mar 2018
 * https://www.hackerrank.com/domains/data-structures/arrays
 * https://github.com/bibhas-abhishek/projects/tree/master/QHEAP
 **/

public class QHEAP {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < n; i++) {
            int cmd = s.nextInt();
            switch (cmd) {
                case 1:
                    int val = s.nextInt();
                    pq.add(val);
                    break;
                case 2:
                    val = s.nextInt();
                    pq.remove(val);
                    break;
                case 3:
                    val = pq.peek();
                    System.out.println(val);
                    break;
            }
        }
        s.close();
    }

}
