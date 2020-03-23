package charpter3;

import java.util.HashMap;
import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {

    }

    public void clear() {

    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    public AnyType set(int index, AnyType newVal) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[index];
        theItems[index] = newVal;
        return old;
    }

    public void add(int index, AnyType x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = index + 1; i < size(); i++) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = x;

        theSize++;
    }

    public void add(AnyType x) {
        add(size(), x);
    }

    public void remove(int index) {
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;

    }

    public void addAll(Iterable<? extends AnyType> items) {
        for (AnyType it : items) {
            add(it);
        }
    }

    public void removeAll(Iterable<? extends AnyType> items) {
        for (AnyType it : items) {
            remove(indexOf(it));
        }
    }

    public boolean contains(AnyType item) {
        return indexOf(item) != -1;

    }

    /**
     * null 代表的是空对象，对空对象做任何操作都不行的（equals也不行），除了=和==。 null 可以赋值给任何对象。
     * ""代表的是空字符串，即一个字符串的长度是0。
     * 
     * @param item
     * @return
     */
    public Integer indexOf(AnyType item) {
        if (item == null) {
            for (int i = 0; i < theSize; i++) {
                if (theItems[i] == null) {
                    return i;
                } else {
                    for (int j = 0; i < theSize; i++) {
                        if (theItems[i].equals(item)) {
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<AnyType> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            return theItems[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }

    }

}
