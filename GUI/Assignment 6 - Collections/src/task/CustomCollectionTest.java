package task;

import static org.junit.jupiter.api.Assertions.*;
import task.CustomCollection.CustomIterator;

import javax.swing.*;

class CustomCollectionTest {
    private CustomCollection<Integer> collection = new CustomCollection();

    @org.junit.jupiter.api.Test
    void add() {
        int previousSize = collection.getElements().size();
        collection.add(6);
        assertEquals(collection.getElements().size(),previousSize+1);
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        collection.add(1);
        collection.add(2);
        collection.add(5);
        collection.iterator();
    }

    //  ASSIGNMENT 6

    @org.junit.jupiter.api.Test
    void listIterator() {
        collection.add(55);
        collection.add(66);
        collection.add(77);
        collection.listIterator();
    }

    @org.junit.jupiter.api.Test
    void remove() {
        collection.add(1);
        collection.add(2);
        int previousSize = collection.getElements().size();
        CustomIterator iterator = collection.getIterator();
        iterator.next();
        iterator.next();
        System.out.println("Elements before remove: ");
        collection.listIterator();
        iterator.remove();
        System.out.println("Elements after remove: ");
        collection.listIterator();
        assertEquals(collection.getElements().size(), previousSize-1);
    }

}