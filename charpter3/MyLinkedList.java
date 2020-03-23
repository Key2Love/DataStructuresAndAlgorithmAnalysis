package charpter3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, null, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    private Node<AnyType> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<AnyType> getNode(int idx, int lower, int upper) {
        Node<AnyType> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = size(); i > idx; i--) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public AnyType set(int idx, AnyType newVal) {
        AnyType oldVal = getNode(idx).data;
        getNode(idx).data = newVal;
        return oldVal;
    }

    public AnyType remove(int idx) {
        return remove(getNode(idx));
    }

    public AnyType remove(Node<AnyType> P) {
        P.next.prev = P.prev;
        P.prev.next = P.next;
        theSize--;
        modCount++;

        return P.data;
    }

    /**
     * 3.11 Assume that a singly linked list is implemented with a header node, but
     * no tail node, and that it maintains only a reference to the header node.
     * Write a class that includes methods to a. return the size of the linked list
     * b. print the linked list c. test if a value x is contained in the linked list
     * d. add a value x if it is not already contained in the linked list e. remove
     * a value x if it is contained in the linked list
     */
    public int returnSize() {
        return size();
    }

    public void printList() {
        Node p = beginMarker.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public boolean contains(AnyType t) {
        Node p = beginMarker.next;
        int size = size();
        for (int i = 0; i < size; i++) {
            if (p.data.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public boolean addIfNotContain(Node<AnyType> node){
        if (contains(node.data)) {
            return false;
        }
        Node p = beginMarker.next;
        while (p!=null){
            p=p.next;
        }
        p.next = node;
        return true;

    }

    public boolean removeIfContain(Node<AnyType> node){
        if (contains(node.data)){
            remove(node);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        public AnyType next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }

        public boolean contains(AnyType x) {
            Node node = beginMarker;

            while (node != endMarker && node.data.equals(x)) {
                node = node.next;
            }
            return (node != endMarker);

        }
    }
}