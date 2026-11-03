package list.sequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 顺序表测试
 *
 * @author tianxing
 */
class SequenceListTest {

    @Test
    @DisplayName("添加与查询测试")
    void addAndGet() {
        SequenceList<String> list = new SequenceList<>(3);
        assertTrue(list.isEmpty());
        list.add("a");
        list.add("b");
        list.add(1, "c");
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
        assertEquals("b", list.get(2));
        assertEquals(1, list.indexOf("c"));
        assertEquals(-1, list.indexOf("z"));
        // [a, c, b]
        System.out.println(list);
        assertEquals("[a, c, b]", list.toString());
    }

    @Test
    @DisplayName("删除与清空测试")
    void removeAndClear() {
        SequenceList<String> list = new SequenceList<>(3);
        list.add("a");
        list.add("c");
        list.add("b");
        assertEquals("c", list.remove(1));
        assertEquals(2, list.size());
        // [a, b]
        System.out.println(list);
        assertEquals("[a, b]", list.toString());
        list.clear();
        // []
        System.out.println(list);
        assertEquals("[]", list.toString());
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("迭代器遍历测试")
    void iterator() {
        SequenceList<String> list = new SequenceList<>(3);
        list.add("a");
        list.add("b");
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item);
        }
        assertEquals("ab", sb.toString());
    }
}
