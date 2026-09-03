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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        ListNode[] result = new ListNode[k];
        int basecase = length / k;
        int extra = length % k;
        curr = head;
        for (int j = 0; j < k; j++) {
            int partlength = basecase;
            if (extra > 0) {
                partlength++;
                extra--;
            }

            if (partlength == 0) {
                result[j] = null;
            } else {
                result[j] = curr;
                for (int i = 1; i < partlength; i++) {
                    curr = curr.next;
                }
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }

        return result;
    }
}