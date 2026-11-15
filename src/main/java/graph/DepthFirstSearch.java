package graph;

import lombok.Getter;

/**
 * 深度优先搜索
 *
 * @author tianxing
 */
@Getter
public class DepthFirstSearch {

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
    public DepthFirstSearch(UndirectedGraph graph, int s) {
        marked = new boolean[graph.getV()];
        dfs(graph, s);
    }

    /**
     * 找出graph中与顶点v连通的所有顶点
     *
     * @param graph 无向图
     * @param v     顶点v
     */
    private void dfs(UndirectedGraph graph, int v) {
        // 标记顶点v为已访问
        marked[v] = true;
        // 连通顶点数量加1
        count++;
        // 遍历顶点v的所有邻接顶点w
        for (int w : graph.getNeighbors(v)) {
            // 如果顶点w未被访问
            if (!marked[w]) {
                // 递归访问顶点w
                dfs(graph, w);
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
