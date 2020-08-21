import java.util.*;

public class JavaTest {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] array = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (array[0].charAt(0) == '0') {
            return "0";
        }
        return String.join("", array);
    }

    public static void main(String[] args) {
        int[] array = { 3, 30, 34, 5, 9 };
        System.out.println(new JavaTest().largestNumber(array));
    }
}
