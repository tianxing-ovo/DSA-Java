package graph;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先搜索
 *
 * @author tianxing
 */
@Getter
public class BreadthFirstSearch {

    // 标记顶点是否已被访问
    private final boolean[] marked;
    // 与顶点s连通的顶点总数(包含s自身)
    private int count;

    /**
     * 构造方法
     *
     * @param graph 无向图
     * @param s     顶点s
     */
    public BreadthFirstSearch(UndirectedGraph graph, int s) {
        marked = new boolean[graph.getV()];
        bfs(graph, s);
    }

    /**
     * 找出graph中与顶点s连通的所有顶点
     *
     * @param graph 无向图
     * @param s     顶点s
     */
    private void bfs(UndirectedGraph graph, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        // 标记顶点s为已访问
        marked[s] = true;
        count++;
        // 将顶点s加入队列
        queue.offer(s);
        // 遍历队列中的顶点
        while (!queue.isEmpty()) {
            // 从队列中弹出一个顶点v
            int v = queue.poll();
            // 遍历顶点v的所有邻接顶点w
            for (int w : graph.getNeighbors(v)) {
                // 如果顶点w未被访问
                if (!marked[w]) {
                    // 标记顶点w为已访问
                    marked[w] = true;
                    count++;
                    // 将顶点w加入队列
                    queue.offer(w);
                }
            }
        }
    }

    /**
     * 判断顶点w是否与顶点s连通
     *
     * @param w 顶点w
     * @return 是否连通
     */
    public boolean marked(int w) {
        return marked[w];
    }
}
