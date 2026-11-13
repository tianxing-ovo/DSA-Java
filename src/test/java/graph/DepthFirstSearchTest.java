package graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 深度优先搜索测试
 *
 * @author tianxing
 */
class DepthFirstSearchTest {

    @Test
    @DisplayName("连通性与顶点计数测试")
    void markedAndCount() {
        UndirectedGraph graph = new UndirectedGraph(13);
        // 连通分量1(顶点0~6)
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        // 连通分量2(顶点7~8)
        graph.addEdge(7, 8);
        // 连通分量3(顶点9~12)
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
        // 从顶点0开始深度优先搜索
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        // 与顶点0相通的顶点数量为7
        assertEquals(7, dfs.getCount());
        // 顶点5与顶点0相通
        assertTrue(dfs.marked(5));
        // 顶点7与顶点0不相通
        assertFalse(dfs.marked(7));
    }
}
