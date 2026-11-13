package graph;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 无向图
 *
 * @author tianxing
 */
@Getter
public class UndirectedGraph {

    // 顶点数
    private final int V;
    // 边的数量
    private int E;
    // 邻接表
    private final List<List<Integer>> adj;

    public UndirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    /**
     * 添加边
     *
     * @param v 顶点v
     * @param w 顶点w
     */
    public void addEdge(int v, int w) {
        // 双向记录邻接关系
        adj.get(v).add(w);
        adj.get(w).add(v);
        E++;
    }

    /**
     * 获取顶点v的所有邻接顶点
     *
     * @param v 顶点v
     * @return 邻接顶点列表
     */
    public List<Integer> getNeighbors(int v) {
        return adj.get(v);
    }
}
