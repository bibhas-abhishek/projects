/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: PowerSets
*- 06 Nov 2021 12:52 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/subsets-ii
-------------------------------------------*/

import java.util.ArrayList;
import java.util.List;

public class PowerSets {

    public ArrayList<ArrayList<String>> getSubsets(List<String> set) {
        ArrayList<ArrayList<String>> allSubsets = new ArrayList<>();
        int max = 1 << set.size();
        for (int k = 0; k < max; k++) {
            ArrayList<String> subset = convertToInt(k, set);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    private ArrayList<String> convertToInt(int x, List<String> set) {
        ArrayList<String> subset = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    public static void main(String[] args) {
        List<String> set = new ArrayList<>();
        set.add("a1");
        set.add("a2");
        set.add("a3");
        PowerSets driver = new PowerSets();
        System.out.print(driver.getSubsets(set));
    }
}
