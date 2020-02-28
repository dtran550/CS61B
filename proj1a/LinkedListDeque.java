public class LinkedListDeque<T> {

    private boolean item;

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    // Creates an empty doubly linked list deque
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        this.size = 0;
    }

    public void addFirst(T newItem) {
        Node newNode = new Node(newItem, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        this.size += 1;
    }

    public void addLast(T newItem) {
        Node newNode = new Node(newItem, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        this.size += 1;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        if (size == 0) {
            System.out.println("Your list is empty.");
            return;
        }
        Node pointer = sentinel.next;
        while (pointer != sentinel) {
            System.out.print(pointer.item);
            pointer = pointer.next;
            if (pointer != sentinel) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        Node pointer = sentinel.next;
        if (pointer == sentinel) {
            return null;
        }
        sentinel.next = pointer.next;
        pointer.next.prev = sentinel;
        size -= 1;
        return pointer.item;
    }

    public T removeLast() {
        Node pointer = sentinel.prev;
        if (pointer == sentinel) {
            return null;
        }
        sentinel.prev = pointer.prev;
        pointer.prev.next = sentinel;
        size -= 1;
        return pointer.item;
    }

    public T get(int index) {
        if (size == 0 || index >= size) {
            return null;
        }
        Node pointer = sentinel.next;
        while (index > 0) {
            pointer = pointer.next;
            index -= 1;
        }
        return pointer.item;
    }

    private T getRecursiveHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

    public T getRecursive(int index) {
        if (size == 0 || index >= size) {
            return null;
        } else {
            return getRecursiveHelper(index, sentinel.next);
        }
    }
}
