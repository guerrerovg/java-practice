package list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {
    private List<String> list;

    @Before
    public void initialize() {
        list = new List<>();
    }

    @Test
    public void listInitialValue() {
        assertEquals(0, list.size());
    }

    @Test
    public void addingGrowsListByOne() {
        list.add("1");
        assertEquals(1, list.size());
    }

    @Test
    public void addedElementIsInList() {
        list.add("1");
        assertEquals("1", list.get(0));
    }

    @Test
    public void addingOneHundredElementsGrowsList() {
        int elements = 100;
        for (int i = 0; i < elements; i++) {
            list.add(i + "");
        }

        assertEquals(elements, list.size());
    }

    @Test
    public void elementIsInList() {
        list.add("5");
        assertTrue(list.contains("5"));
    }

    @Test
    public void removedElementIsNotInList() {
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }

        String delete = "50";
        list.remove(delete);

        assertFalse(list.contains(delete));
    }

    @Test
    public void outboundsThrowException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
    }
}
