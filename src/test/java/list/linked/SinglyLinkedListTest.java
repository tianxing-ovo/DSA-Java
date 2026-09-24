package list.linked;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 单向链表单元测试
 *
 * @author tianxing
 */
public class SinglyLinkedListTest {

    @Test
    @DisplayName("单向链表单元测试")
    public void test() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());
        list.addFirst("a");
        list.addLast("b");
        list.insert(1, "c");
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
        assertEquals(1, list.indexOf("c"));
        assertEquals(-1, list.indexOf("d"));
        assertEquals("a", list.getFirst());
        assertEquals("b", list.getLast());
        assertEquals("c", list.get(1));
        assertEquals("[a -> c -> b]", list.toString());
        assertEquals("c", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("[a -> b]", list.toString());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertEquals("[]", list.toString());
        list.addLast("x");
        assertEquals("x", list.getFirst());
        assertEquals("x", list.getLast());
        assertEquals(1, list.size());
    }
}