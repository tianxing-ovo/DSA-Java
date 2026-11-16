package graph;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 深度优先路径查找
 *
 * @author tianxing
 */
@Getter
public class DepthFirstPaths {

    // 标记顶点是否已被访问
    private final boolean[] marked;
    // 起点
    private final int s;
    // 索引代表顶点(值代表从起点s到当前顶点路径上的前驱顶点)
    private final int[] edgeTo;

    /**
     * 构造方法
     *
     * @param graph 无向图
     * @param s     起点s
     */
    public DepthFirstPaths(UndirectedGraph graph, int s) {
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        this.s = s;
        dfs(graph, s);
    }

    /**
     * 找出graph中与顶点v连通的所有顶点并记录路径前驱顶点
     *
     * @param graph 无向图
     * @param v     顶点v
     */
    private void dfs(UndirectedGraph graph, int v) {
        // 标记顶点v为已访问
        marked[v] = true;
        // 遍历顶点v的所有邻接顶点w
        for (int w : graph.getNeighbors(v)) {
            // 如果顶点w未被访问
            if (!marked[w]) {
                // 记录到达顶点w的前驱顶点为v
                edgeTo[w] = v;
                // 递归访问顶点w
                dfs(graph, w);
            }
        }
    }

    /**
     * 判断从起点s到顶点v是否存在路径
     *
     * @param v 顶点v
     * @return 是否存在路径
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 获取从起点s到顶点v的路径
     *
     * @param v 顶点v
     * @return 路径顶点列表
     */
    @SuppressWarnings("DuplicatedCode")
    public List<Integer> pathTo(int v) {
        // 如果从起点s到顶点v不存在路径
        if (!hasPathTo(v)) {
            return Collections.emptyList();
        }
        Deque<Integer> path = new ArrayDeque<>();
        // 从终点v沿前驱数组倒推至起点s(压栈后顺序即为s -> v)
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        // 添加起点s到路径中
        path.push(s);
        return new ArrayList<>(path);
    }
}
