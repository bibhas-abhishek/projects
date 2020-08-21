public class BinaryStringsNBits {

    public void generateBinaryStrings(int n, char[] string, int index) {
        if (index == n) {
            System.out.println(String.valueOf(string));
            return;
        }

        string[index] = '0';
        generateBinaryStrings(n, string, index + 1);

        string[index] = '1';
        generateBinaryStrings(n, string, index + 1);
    }

    public static void main(String[] args) {
        int n = 8;
        char[] string = new char[n];
        BinaryStringsNBits binaryStringsNBits = new BinaryStringsNBits();
        binaryStringsNBits.generateBinaryStrings(n, string, 0);
    }
}
