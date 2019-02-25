import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {

        private int key;
        private int value;
        private Node prev;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }

    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public void put(int key, int value) {
        Node t;
        if (map.containsKey(key)) {
            t = map.get(key);
            t.value = value; // update key
            updateCache(key);
            return;
        }

        if (map.size() == capacity)
            purgeLRUKey();

        t = new Node(key, value);
        map.put(key, t);

        if (head != null) {
            head.prev = t;
            t.next = head;
        }

        head = t;
        if (tail == null) {
            tail = head;
        }
    }

    public int get(int key) {
        if (map.get(key) == null)
            return -1;
        else {
            updateCache(key);
            return map.get(key).value;
        }
    }


    // delete the last element in dll
    private void purgeLRUKey() {
        map.remove(tail.key);
        tail = tail.prev;
    }

    // delete element and set as head
    // key already exists in the cache
    private void updateCache(int key) {
        if (tail == head || head == map.get(key))
            return; // update not needed if only cache has only one element or
                    // updated key is the head

        // at least 2 elements are present
        Node t = map.get(key);
        if (t == tail) { // next element does not exist
            tail = t.prev;
            tail.next = null;
        } else {
            // next element exists
            t.prev.next = t.next;
            t.next.prev = t.prev;
        }

        // make t as head
        t.next = head;
        head.prev = t;
        head = t;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}
