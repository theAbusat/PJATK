package task;

import static org.junit.jupiter.api.Assertions.*;

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

}