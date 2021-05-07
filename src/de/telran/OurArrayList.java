package de.telran;

import java.util.Arrays;
import java.util.Comparator;
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

    /**
     * The method must sort this list according to the comparator rule
     * @param comparator
     */
    @Override
    public void sort(Comparator<E> comparator) {
        for (int i = 0; i <source.length; i++) {
            for (int j = i+1; j <source.length; j++) {
                int temp = 0;
                if (comparator.compare((E) source[j+1], (E) source[j]) > 0) {
                    source[i] = source[j];
                    source[j] = temp;
                }
            }
        }
        // if (num1<num2) - old style writing for sorting an array with numbers
        // if(comparator.compare(o1, o2)<0) - new style of sorting out source array of objects
        // TODO implement any kind of sort using comparator instead of the operators '>' and '<'


    }

    @Override
    public boolean contains(E elt) {
        return findIndexOfElement(elt) != -1;
         }
    
    private void checkIndex(int x) throws IndexOutOfBoundsException {
        if(x<0 || x >= size) {
            throw new IndexOutOfBoundsException("Index " + x + " is not correct");
        }
    }
//    @Override
//    public Iterator<E> iterator() {
//        Iterator<E> iterator = new ForwardIterator<>((E[])source, size);
//        return iterator;
//    }
//    private class ForwardIterator<T> implements Iterator<T> {
//        int size;
//        T[] source;
//        int currentElementIndex = 0;
//
//        public ForwardIterator(T[] source, int size) {
//            this.source = source;
//            this.size = size;
//            }
//
//        @Override
//        public boolean hasNext() {
//            return currentElementIndex < size;
//        }
//
//        @Override
//        public T next() {
//            T res = source[currentElementIndex];
//            currentElementIndex++;
//            return res;
//        }
//
//    }
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new BackwardIterator<>((E[])source, size);
        return iterator;
    }

    private class BackwardIterator<T> implements Iterator<T> {
        int size;
        T[] source;
        int currentElementIndex = 0;

        public BackwardIterator(T[] source, int size) {
            this.source = source;
            this.size = size;
            this.currentElementIndex = size-1;
        }

        @Override
        public boolean hasNext() {
            return currentElementIndex >= 0;
        }

        @Override
        public T next() {
            T res = source[currentElementIndex];
            currentElementIndex--;
            return res;
        }
    }
}



