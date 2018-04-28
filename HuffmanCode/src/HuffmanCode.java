import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 27 Apr 2018
 * https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/HuffmanCode
 **/

public class HuffmanCode {

    private static class HuffmanNode {

        int frequency;
        char data;
        HuffmanNode left, right;

        HuffmanNode(char data, int frequency) {
            this.frequency = frequency;
            this.data = data;
            left = right = null;
        }

    }

    private static HuffmanNode root = null;

    private static void buildTree(char[] val, int[] freq) {
        Queue<HuffmanNode> minHeap = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
        for (int i = 0; i < val.length; i++)
            minHeap.add(new HuffmanNode(val[i], freq[i]));

        while (minHeap.size() > 1) {
            HuffmanNode leftChild = minHeap.poll();
            HuffmanNode rightChild = minHeap.poll();
            HuffmanNode internalRoot = new HuffmanNode('$', leftChild.frequency + rightChild.frequency);
            internalRoot.left = leftChild;
            internalRoot.right = rightChild;
            root = internalRoot;
            minHeap.add(internalRoot);
        }
    }

    private static void printCodes(HuffmanNode root, String s) {
        if (root == null)
            return;

        if (root.left == null && root.right == null && root.data != '$')
            System.out.println(root.data + " : " + s);


        printCodes(root.left, s + '0');
        printCodes(root.right, s + '1');
    }

    private static String decodeString(HuffmanNode node, String s) {
        List<Character> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        decodeStringUtil(node, s, 0, result);
        for (char ch : result)
            builder.append(ch);
        return builder.toString();
    }

    private static void decodeStringUtil(HuffmanNode node, String s, int index, List<Character> result) {
        if (node == null)
            return;

        if (node.left == null && node.right == null && Character.isLetter(node.data)) {
            result.add(node.data);
            if (index >= s.length())
                return;

            decodeStringUtil(root, s, index, result);
        }

        if (s.charAt(index) == '0')
            decodeStringUtil(node.left, s, index + 1, result);
        else
            decodeStringUtil(node.right, s, index + 1, result);
    }

    public static void main(String[] args) {
        /*char[] val = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};*/

        char[] val = {'A', 'B', 'C'};
        int[] freq = {3, 1, 1};
        buildTree(val, freq);
        printCodes(root, "");
        System.out.println(decodeString(root, "1001011"));
    }

}
