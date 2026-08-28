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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = groupPrev;

            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) {
                    break;
                }
            }
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;
            ListNode groupStart = groupPrev.next;

            ListNode prev = groupNext;
            ListNode curr = groupStart;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            groupPrev.next = prev;

            groupPrev = groupStart;
        }
        return dummy.next;
    }
}