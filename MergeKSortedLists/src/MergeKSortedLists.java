import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 07 May 2018
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MergeKSortedLists
 **/

public class MergeKSortedLists {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    private static ListNode merge2Lists(ListNode headA, ListNode headB) {
        if (headA == null)
            return headB;

        if (headB == null)
            return headA;

        if (headA.val <= headB.val) {
            headA.next = merge2Lists(headA.next, headB);
            return headA;
        } else {
            headB.next = merge2Lists(headB.next, headA);
            return headB;
        }
    }

    private static ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start > end)
            return null;

        if (start == end)
            return lists[start];

        int mid = start + (end - start) / 2;
        ListNode headA = mergeKLists(lists, start, mid);
        ListNode headB = mergeKLists(lists, mid + 1, end);
        return merge2Lists(headA, headB);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;
        for (ListNode list : lists)
            if (list != null)
                minHeap.offer(list);

        while (minHeap.size() > 0) {
            tail.next = minHeap.poll();
            tail = tail.next;

            if (tail.next != null)
                minHeap.offer(tail.next);
        }
        return dummy.next;
    }

}
