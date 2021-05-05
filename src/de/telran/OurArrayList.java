package de.telran;

import java.util.Arrays;
import java.util.Iterator;

public class OurArrayList<E> implements OurList<E> {
    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(E elt) {
        if (size == source.length)
            increaseCapacity();

        source[size] = elt;
        size++;
    }
    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E)source[index];
    }

//    @Override
//    public E remove(int index) {
//        checkIndex(index);
//        E temp = get(index);
//        for (int i = index; i < size-1; i++) {
//            source[index] = source[index+1];
//        }
//        size--;
//        return temp;
//    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E res = (E) source[index];
        System.arraycopy(source, index+1, source, index, size-index-1 );
        size--;
        source[size] = null;
        return res;
    }
    @Override
    public boolean remove(E elt) {
        int index = findIndexOfElement(elt);
        if(index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * @param elt
     * @return the index of elt if found, -1 otherwise
     */
    private int findIndexOfElement(E elt) {
        if (elt == null) {
            for (int i = 0; i < size; i++) {
                if(source[i] == null) {
                    return i;
                }
                return -1;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if(elt.equals(source[i])) {
                    return i;
                }
                return -1;
            }
        }
        return -1;

    }

  @Override
    public int size() {
        int counter = 0;
      for (int i = 0; i < size; i++) {
          counter++;
      }
        return counter;
    }

//    @Override
//    public int size() {
//        return size;
//    }
    @Override
    public void set(int index, E elt) {
        checkIndex(index);
        source[index] = elt;
    }

//    @Override
//    public boolean contains(E elt) {
//        for (int i = 0; i < size; i++) {
//            if(elt.equals(source[i])) {
//                return true;
//            }
//        }
//        return false;
//    }
    @Override
    public boolean contains(E elt) {
        return findIndexOfElement(elt) != -1;
     
    }
    
    private void checkIndex(int x) throws IndexOutOfBoundsException {
        if(x<0 || x >= size) {
            throw new IndexOutOfBoundsException("Index " + x + " is not correct");
        }

    }

//====================================================================

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new ForwardIterator<>((E[])source);
        return iterator;
    }

    private static class ForwardIterator<T> implements Iterator<T> {
        private Object[] sourceNew;
        private int curIndex;

        public ForwardIterator(T[] source) {
            this.sourceNew = source;
            this.curIndex = 0;
            }

        @Override
        public boolean hasNext() {
            if(curIndex < sourceNew.length ) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
        return (T) sourceNew[curIndex++];
        }

    }
}

