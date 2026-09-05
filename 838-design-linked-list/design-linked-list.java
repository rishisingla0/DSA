class MyLinkedList {

    class Node {

        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node dummyHead;
    Node dummyTail;
    int size;

    public MyLinkedList() {
        dummyHead = new Node(0);
        dummyTail = new Node(0);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

        size = 0;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }

        Node curr;
        if (index < size / 2) {
            curr = dummyHead.next;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        }

        else {
            curr = dummyTail.prev;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        Node next = dummyHead.next;
        Node curr = new Node(val);

        dummyHead.next = curr;
        next.prev = curr;
        curr.prev = dummyHead;
        curr.next = next;

        size++;
    }

    public void addAtTail(int val) {
        Node prev = dummyTail.prev;
        Node curr = new Node(val);

        dummyTail.prev = curr;
        prev.next = curr;
        curr.next = dummyTail;
        curr.prev = prev;

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        Node curr;
        if(index == size) {
            curr = dummyTail;
        }
        else if (index < size / 2) {
            curr = dummyHead.next;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        }
        else {
            curr = dummyTail.prev;
            for(int i = size-1; i > index; i--) {
                curr = curr.prev;
            }
        }

        Node prev = curr.prev;
        Node insert = new Node(val);

        prev.next = insert;
        curr.prev = insert;
        insert.prev = prev;
        insert.next = curr;

        size ++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }

        Node curr;
        if(index < size/2) {
            curr = dummyHead.next;
            for(int i=0; i<index; i++) {
                curr = curr.next;
            }
        }
        else {
            curr = dummyTail.prev;
            for(int i=size-1; i>index; i--) {
                curr = curr.prev;
            }
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        curr.next = null;
        curr.prev = null;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */