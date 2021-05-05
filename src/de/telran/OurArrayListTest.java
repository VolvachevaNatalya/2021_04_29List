package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {

    OurArrayList<Integer> integerList = new OurArrayList<>();
    @Test
    public void testSize_newList() {
        assertEquals(0, integerList.size());
    }
    @Test
    public void testAddAndGet_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        assertEquals(3, integerList.size());

        assertEquals(-7, integerList.get(0));
        assertEquals(-17, integerList.get(1));
        assertEquals(5, integerList.get(2));
    }

    @Test
    public void testAddAndGet_severalElements_throwsIOOBE() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(-3);
        });

//        try{
//            integerList.get(-3);
//            fail();
//        } catch (IndexOutOfBoundsException e) {
//            assertTrue(true);
//        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(-1);
        });

    }
    @Test
    public void testSetAndGetOneElement(){
        integerList.add(5);
        assertEquals(5, integerList.get(0));
        integerList.set(0,null);
        assertNull(integerList.get(0));
        integerList.add(null);
        assertEquals(2, integerList.size());
        integerList.set(1,5);
        assertEquals(2, integerList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(3);
        });
        integerList.remove(0);
        integerList.remove(0);
        assertEquals(0, integerList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.set(0,2);
        });
        integerList.add(5);
        integerList.set(0,-2);
        assertEquals(-2, integerList.get(0));

    }
    @Test
    public void removeElByIndex() {
        integerList.add(5);
        integerList.add(-5);
        integerList.add(15);
        assertEquals(3, integerList.size());
        integerList.remove(0);
        assertEquals(2, integerList.size());
        integerList.remove(0);
        integerList.remove(0);
        assertEquals(0, integerList.size());
        integerList.add(5);
        integerList.add(-5);
        integerList.add(15);
        assertEquals(5, integerList.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.remove(5);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.remove(-5);
        });
        integerList.set(0, null);
        assertNull(integerList.remove(0));
    }

    @Test
    public void removeByEl() {
        integerList.add(5);
        integerList.add(-5);
        integerList.add(15);
        assertEquals(3, integerList.size());
        integerList.remove(integerList.get(0));
        assertEquals(2, integerList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.remove(integerList.get(5));
        });
        integerList.remove(integerList.get(0));
        integerList.remove(integerList.get(0));
        assertEquals(0, integerList.size());
        integerList.add(null);
        integerList.remove(integerList.get(0));
        assertEquals(0, integerList.size());
    }

    @Test
    public void size() {
        assertEquals(0, integerList.size());
        integerList.add(5);
        assertEquals(1, integerList.size());
        integerList.add(15);
        integerList.add(25);
        assertEquals(3, integerList.size());
        integerList.remove(0);
        integerList.remove(0);
        integerList.remove(0);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.remove(integerList.get(0));
        });
    }

    @Test
    public void contains(){
        integerList.add(5);
        integerList.add(-5);
        integerList.add(15);
        assertTrue(integerList.contains(5));
        assertFalse(integerList.contains(10));
        assertFalse(integerList.contains(null));
        integerList.remove(0);
        integerList.remove(0);
        integerList.remove(0);
        assertFalse(integerList.contains(null));
        integerList.add(null);
        assertTrue(integerList.contains(null));
    }



}