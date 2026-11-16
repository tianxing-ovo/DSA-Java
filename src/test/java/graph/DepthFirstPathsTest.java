package graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 深度优先路径查找测试
 *
 * @author tianxing
 */
class DepthFirstPathsTest {

    @Test
    @DisplayName("路径查找测试")
    void pathTo() {
        UndirectedGraph graph = new UndirectedGraph(6);
        // 添加8条边
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        // 从起点0开始深度优先搜索路径
        DepthFirstPaths paths = new DepthFirstPaths(graph, 0);
        // 获取从起点0到顶点4的路径
        List<Integer> path = paths.pathTo(4);
        // 验证路径是否正确
        assertEquals(List.of(0, 2, 3, 4), path);
    }
}
