/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: RemoveNthNodeLL
*- 10 Nov 2021 1:09 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/remove-nth-node-from-end-of-list
-------------------------------------------*/

public class RemoveNthNodeLL {

    public class ListNode {
        int      val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode runner = dummy, p = dummy;
        dummy.next  = head;
        while(n > 0 && runner != null) {
            runner = runner.next;
            n = n - 1;
        }

        if(runner == null) {
            return head;
        }

        while(runner.next != null) {
            p = p.next;
            runner = runner.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
