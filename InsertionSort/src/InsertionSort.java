/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 10 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/InsertionSort
 */

public class InsertionSort {

    public static void main(String[] args) {
        int[] myArray = {3, 6, 4, 2, 1};
        sort(myArray);
        print(myArray);
    }

    public static void sort(int[] myArray) {
        int key, j;
        for (int i = 1; i < myArray.length; i++) {
            key = myArray[i];
            j = i - 1;
            while (j >= 0 && myArray[j] > key) {
                myArray[j + 1] = myArray[j];
                j -= 1;
            }
            myArray[j + 1] = key;
        }
    }

    public static void print(int[] myArray) {
        for (int element : myArray)
            System.out.print(element + " ");
        System.out.println();
    }

}
