import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 05 Apr 2018
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/CopyLinkedListRandomNodes
 **/

public class CopyLinkedListRandomNodes {

    private static class RandomListNode {

        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
            next = random = null;
        }

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<>();

        RandomListNode node = head;
        while (node != null) {
            hashMap.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            hashMap.get(node).next = hashMap.get(node.next);
            hashMap.get(node).random = hashMap.get(node.random);
            node = node.next;
        }
        return hashMap.get(head);
    }

}
