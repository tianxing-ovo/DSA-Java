package list.linked;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 单向链表测试
 *
 * @author tianxing
 */
class SinglyLinkedListTest {

    @Test
    @DisplayName("添加与查询测试")
    void addAndGet() {
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
    }

    @Test
    @DisplayName("删除与清空测试")
    void removeAndClear() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("a");
        list.addLast("b");
        list.insert(1, "c");
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

    @Test
    @DisplayName("迭代器遍历测试")
    void iterator() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item);
        }
        assertEquals("abc", sb.toString());
    }
}
