import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FullCountingSort {

    private static class Entry implements Comparable<Entry> {

        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Entry o) {
            return this.key - o.key;
        }

    }

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            List<Entry> entryList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] entries = in.readLine().split(" ");
                entryList.add(new Entry(Integer.parseInt(entries[0]), entries[1]));
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < entryList.size(); i++)
                builder.append((i < entryList.size() / 2) ? "-" : entryList.get(i).value).append(" ");
            System.out.print(builder.toString());
        } catch (IOException ex) {
            System.out.print("An exception occurred" + ex);
        }
    }
}
