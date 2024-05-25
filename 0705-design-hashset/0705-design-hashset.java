class MyHashSet {
    private static final int MAX_SIZE = 10_000;
    private ListNode [] set;

    public MyHashSet() {
        set = new ListNode [MAX_SIZE];
    }
    
    public void add(int key) {
        int index = hash(key);
        ListNode newNode = new ListNode(key);
        if (set[index] == null) {
            set[index] = newNode;
            return;
        }
        ListNode curr = set[index];
        while (true) {
            if (curr.getValue() == key) {
                return;
            }
            if (curr.getNext() == null) {
                break;
            }
            curr = curr.getNext();
        }
        curr.setNext(newNode);
    }
    
    public void remove(int key) {
        int index = hash(key);
        ListNode curr = set[index];
        if (curr == null) {
            return;
        }
        if (curr.getValue() == key) {
            set[index] = curr.getNext();
            return;
        }
        while (curr.getNext() != null) {
            if (curr.getNext().getValue() == key) {
                curr.setNext(curr.getNext().getNext());
                return;
            }
            curr = curr.getNext();
        }
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        ListNode curr = set[index];
        while (curr != null) {
            if (key == curr.getValue()) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    private int hash (int value) {
        return value % MAX_SIZE;
    }
}

class ListNode {
    private int value;
    private ListNode next;

    public ListNode (int value) {
        this.value = value;
    }

    public int getValue () {
        return value;
    }

    public ListNode getNext () {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
