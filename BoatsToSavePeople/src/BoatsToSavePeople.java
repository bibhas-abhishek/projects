import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Aug 2018
 * https://leetcode.com/problems/boats-to-save-people/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/BoatsToSavePeople
 */

public class BoatsToSavePeople {

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, result = 0;
        while (i <= j) {
            result += 1;
            if (people[i] + people[j] <= limit)
                i += 1;
            j -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

}
