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
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode head1 = first;
        ListNode second = new ListNode(0);
        ListNode head2 = second;

        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = null;

            if(curr.val < x) {
                first.next = curr;
                first = first.next;
            } else {
                second.next = curr;
                second = second.next;
            }
            curr = next;
        }

        first.next = head2.next;
        return head1.next;
    }
}