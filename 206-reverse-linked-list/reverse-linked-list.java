/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        return reverse(curr, prev);
    }

    public ListNode reverse(ListNode curr, ListNode prev) {
        if(curr == null) {
            return prev;
        }

        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

        return reverse(curr, prev);
    }
}