public class ArrayDeque<T> {
    private int curSize;
    private T [] arrayDeque;
    private int capacity;
    private int beg;

    public ArrayDeque() {
        arrayDeque = (T[]) new Object[8];
        curSize = 0;
        capacity = 8;
        beg = 0;
    }

    private int absoluteIndex(int index) {
        if (index < 0) {
            index += capacity;
        } else if (index >= capacity) {
            index -= capacity;
        }
        return index;
    }

    private void resize(double factor) {
        double newCapacity = factor * capacity;
        T[] newArray = (T[]) new Object[(int) newCapacity];
        for (int i = beg, num = 0; num < curSize; num++, i++) {
            if (i >= capacity) {
                i = 0;
            }
            newArray[num] = arrayDeque[i];
        }
        arrayDeque = newArray;
        beg = 0;
        capacity = (int) newCapacity;
    }

    public void addFirst(T item) {
        if (curSize == capacity) {
            resize(2);
        }
        int offset = absoluteIndex(beg - 1);
        arrayDeque[offset] = item;
        curSize += 1;
        beg = offset;
    }

    public void addLast(T item) {
        if (curSize == capacity) {
            resize(2);
        }
        int offset = absoluteIndex(beg + curSize);
        arrayDeque[offset] = item;
        curSize += 1;
    }

    public boolean isEmpty() {
        if (curSize == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return curSize;
    }

    public void printDeque() {
        if (curSize == 0) {
            System.out.println("Deque is currently empty.");
            return;
        }
        int remaining = curSize;
        for (int i = beg; remaining > 0; remaining--, i++) {
            if (i >= capacity) {
                i = 0;
            }
            System.out.print(arrayDeque[i]);
            if (remaining != 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (curSize == 0) {
            return null;
        }
        T item = arrayDeque[beg];
        beg += 1;
        if (beg >= capacity) {
            beg = 0;
        }
        curSize -= 1;
        if (curSize >= 16 && ((curSize * 100) / capacity) < 25) {
            resize(0.5);
        }
        return item;
    }

    public T removeLast() {
        if (curSize == 0) {
            return null;
        }
        int offset = absoluteIndex(beg + curSize - 1);
        T item = arrayDeque[offset];
        curSize -= 1;
        if (capacity >= 16 && ((curSize * 100) / capacity) < 25) {
            resize(0.5);
        }
        return item;
    }

    public T get(int index) {
        if (index >= curSize) {
            return null;
        }
        int offset = absoluteIndex(beg + index);
        return arrayDeque[offset];
    }
}
