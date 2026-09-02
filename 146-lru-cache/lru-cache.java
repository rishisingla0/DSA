class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node dummyHead;
    Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        dummyHead = new Node(0, 0);
        dummyTail = new Node(0, 0);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            removeNode(node);
            addToMru(node);
            return node.value;
        }
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            node.value = value;
            addToMru(node);
        } else if (map.size() < capacity) {
            Node node = new Node(key, value);
            map.put(key, node);
            addToMru(node);
        } else {
            Node node = new Node(key, value);
            Node lru = dummyHead.next;
            removeNode(lru);
            map.remove(lru.key);
            addToMru(node);
            map.put(key, node);
        }
    }

    public void addToMru(Node node) {
        Node temp = dummyTail.prev;
        temp.next = node;
        dummyTail.prev = node;
        node.prev = temp;
        node.next = dummyTail;
    }

    public void removeNode(Node node) {
        Node temp = node.prev;
        Node temp2 = node.next;
        temp.next = temp2;
        temp2.prev = temp;

        node.prev = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */