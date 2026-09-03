/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while(curr != null) {

            if(curr.child == null && curr.next != null) {
                curr = curr.next;
            } 

            else if(curr.child != null) {
                if(curr.next != null) {
                    stack.push(curr.next);
                }
                
                Node temp = curr.child;
                curr.next = temp;
                temp.prev = curr;
                curr.child = null;

                curr = temp;
            }

            else if(curr.next == null && !stack.isEmpty()) {
                Node temp = stack.pop();
                curr.next = temp;
                temp.prev = curr;
                curr = temp;
            }

            else {
                break;
            }
        }

        return head;
    }
}