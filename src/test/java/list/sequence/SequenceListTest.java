package list.sequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 顺序表单元测试
 *
 * @author tianxing
 */
public class SequenceListTest {

    @Test
    @DisplayName("顺序表全功能测试")
    public void test() {
        SequenceList<String> list = new SequenceList<>(3);
        assertTrue(list.isEmpty());
        // 添加元素
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
        assertEquals("[a, c, b]", list.toString());
        // [a, c, b]
        System.out.println(list);
        assertEquals("c", list.remove(1));
        // [a, b]
        System.out.println(list);
        assertEquals("[a, b]", list.toString());
        // 遍历测试
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item);
        }
        assertEquals("ab", sb.toString());
        list.clear();
        // []
        System.out.println(list);
        assertEquals("[]", list.toString());
        assertTrue(list.isEmpty());
    }
}