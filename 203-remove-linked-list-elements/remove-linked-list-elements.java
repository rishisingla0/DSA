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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode prev = dummy;

        while (curr != null) {
            if (curr.val == val) {
                curr = curr.next;
                prev.next = curr;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}