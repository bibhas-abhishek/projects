public class InsertionSort {

    public static void main(String[] args) {
        int[] myArray = {3, 6, 4, 2, 1};
        sort(myArray);
    }

    public static void sort(int[] myArray) {
        int value, hole;
        for (int i = 1; i < myArray.length; i++) {
            value = myArray[i];
            hole = i;
            while (hole > 0 && myArray[hole - 1] > value) {
                myArray[hole] = myArray[hole - 1];
                hole--;
            }
            myArray[hole] = value;
            print(myArray);
        }
    }

    public static void print(int[] myArray) {
        for (int element : myArray)
            System.out.print(element + " ");
        System.out.println();
    }

}
