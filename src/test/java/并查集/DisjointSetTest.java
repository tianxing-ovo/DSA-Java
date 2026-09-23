package 并查集;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 并查集单元测试
 *
 * @author tianxing
 */
public class DisjointSetTest {

    @Test
    @DisplayName("并查集全功能测试")
    public void test() {
        DisjointSet disjointSet = new DisjointSet(5);
        // count: 5  trees: [ (0), (1), (2), (3), (4) ]
        System.out.println(disjointSet);
        disjointSet.union(0, 1);
        disjointSet.union(1, 2);
        // count: 3  trees: [ (0)->(1)<-(2), (3), (4) ]
        System.out.println(disjointSet);
        assertTrue(disjointSet.connected(0, 2));
        disjointSet.union(3, 4);
        // count: 2  trees: [ (0)->(1)<-(2), (3)->(4) ]
        System.out.println(disjointSet);
        assertFalse(disjointSet.connected(0, 3));
        disjointSet.union(0, 3);
        // count: 1  trees: [ {(0), (2), (3)->(4)}->(1) ]
        System.out.println(disjointSet);
        assertTrue(disjointSet.connected(2, 4));
        // 查找元素3的根节点触发路径压缩
        assertEquals(1, disjointSet.find(3));
        // count: 1  trees: [ {(0), (2), (3), (4)}->(1) ]
        System.out.println(disjointSet);
    }
}