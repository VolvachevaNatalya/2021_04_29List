package de.telran;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public  interface OurList<E> extends Iterable<E>{

        /**
         * add an element to the list
         * @param elt
         */
        public void add(E elt);
        /**
         * the method returns the element by the index
         * @param index
         * @return the element if the index is between 0 and size -1
         * @throws IndexOutOfBoundsException otherwize
         */
        public E get(int index);

        /**
         * removes the element by the index from the collection
         * @param index
         * @return element to be removed
         * @throws IndexOutOfBoundsException if the index is incorrect
         */
        public E remove(int index);

        /**
         * removes the element if found in the collection
         * @param elt to remove
         * @return true if found and removed, otherwize false
         */
        public boolean remove(E elt);

        /**
         *
         * @return size of the collection
         */
        public int size();

        /**
         *
         * @param elt
         * @return true if the element if found in the collection
         */
        public boolean contains(E elt);

        /**
         * puts the element by index
         * @param index
         * @param elt
         * @throws IndexOutOfBoundsException if the index is incorrect
         */
        public void set(int index, E elt);

}

