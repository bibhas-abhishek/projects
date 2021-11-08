/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: PalindromeLinkedList
*- 07 Nov 2021 6:28 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/palindrome-linked-list/
-------------------------------------------*/

import java.util.Stack;

public class PalindromeLinkedList {

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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop().val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
