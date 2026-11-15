package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 畅通工程测试
 *
 * @author tianxing
 */
class TrafficProjectTest {

    private UndirectedGraph graph;

    @BeforeEach
    void setUp() {
        graph = new UndirectedGraph(20);
        // 添加7条已修建好的道路
        graph.addEdge(0, 1);
        graph.addEdge(6, 9);
        graph.addEdge(3, 8);
        graph.addEdge(5, 11);
        graph.addEdge(2, 12);
        graph.addEdge(6, 10);
        graph.addEdge(4, 8);
    }

    @Test
    @DisplayName("深度优先搜索验证城市连通性")
    void checkConnectivityWithDfs() {
        // 从9号城市开始深度优先搜索
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 9);
        // 与9号城市相通的城市数量为3
        assertEquals(3, dfs.getCount());
        // 9号城市与10号城市相通
        assertTrue(dfs.marked(10));
        // 9号城市与8号城市不相通
        assertFalse(dfs.marked(8));
    }

    @Test
    @DisplayName("广度优先搜索验证城市连通性")
    void checkConnectivityWithBfs() {
        // 从9号城市开始广度优先搜索
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 9);
        // 与9号城市相通的城市数量为3
        assertEquals(3, bfs.getCount());
        // 9号城市与10号城市相通
        assertTrue(bfs.marked(10));
        // 9号城市与8号城市不相通
        assertFalse(bfs.marked(8));
    }
}
