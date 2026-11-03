package disjointset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 并查集测试
 *
 * @author tianxing
 */
class DisjointSetTest {

    @Test
    @DisplayName("合并与连通性测试")
    void unionAndConnected() {
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
    }

    @Test
    @DisplayName("查找根节点与路径压缩测试")
    void findAndPathCompression() {
        DisjointSet disjointSet = new DisjointSet(5);
        disjointSet.union(0, 1);
        disjointSet.union(1, 2);
        disjointSet.union(3, 4);
        disjointSet.union(0, 3);
        // count: 1  trees: [ {(0), (2), (3)->(4)}->(1) ]
        System.out.println(disjointSet);
        // 查找元素3的根节点触发路径压缩
        assertEquals(1, disjointSet.find(3));
        // count: 1  trees: [ {(0), (2), (3), (4)}->(1) ]
        System.out.println(disjointSet);
    }
}
