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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null) {
            stack.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(0);
        int carry = 0;

        while(!stack.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = 0;
            int b = 0;
            if(!stack.isEmpty()) {
                a += stack.pop();
            }
            if(!stack2.isEmpty()) {
                b += stack2.pop();
            }
            int c = a + b + carry;
            carry = c/10;
            c = c%10;

            ListNode temp = new ListNode(c);
            ListNode next = dummy.next;
            dummy.next = temp;
            temp.next = next;
        }

        return dummy.next;
    }
}