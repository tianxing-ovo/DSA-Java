package 并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集: 多棵树组成的森林
 *
 * @author tianxing
 */
public class DisjointSet {

    /**
     * parent[i]: 元素i的父节点(根节点指向自身)
     */
    private final int[] parent;

    /**
     * size[i]: 以元素i为根节点的树的节点数量(仅对根节点有效)
     */
    private final int[] size;

    /**
     * 分组数量
     */
    private int count;

    /**
     * 初始化并查集
     *
     * @param n 元素数量
     */
    public DisjointSet(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 判断元素x和元素y是否在同一分组中
     *
     * @param x 元素x
     * @param y 元素y
     * @return 元素x和元素y是否在同一分组中
     */
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 查找元素i的根节点
     *
     * @param i 元素i
     * @return 元素i的根节点
     */
    public int find(int i) {
        // 路径压缩: 回溯时将沿途节点直连根节点
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    /**
     * 合并元素x和元素y到同一分组中
     *
     * @param x 元素x
     * @param y 元素y
     */
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        // 小树合并到大树中
        if (size[xRoot] <= size[yRoot]) {
            parent[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
        count--;
    }

    @Override
    public String toString() {
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        List<Integer> roots = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (i == parent[i]) {
                roots.add(i);
            } else {
                childrenMap.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("count: ").append(count).append("  trees: [ ");
        for (int i = 0; i < roots.size(); i++) {
            sb.append(formatTree(roots.get(i), childrenMap));
            if (i < roots.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    /**
     * 递归格式化以指定节点为根的树结构
     *
     * @param node        当前节点
     * @param childrenMap 父节点到直接子节点的映射表
     * @return 树结构的字符串表示
     */
    private String formatTree(int node, Map<Integer, List<Integer>> childrenMap) {
        List<Integer> children = childrenMap.get(node);
        if (children == null || children.isEmpty()) {
            return "(" + node + ")";
        }
        if (children.size() == 1) {
            return formatTree(children.get(0), childrenMap) + "->(" + node + ")";
        }
        if (children.size() == 2) {
            return formatTree(children.get(0), childrenMap) + "->(" + node + ")<-" + formatTree(children.get(1), childrenMap);
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < children.size(); i++) {
            sb.append(formatTree(children.get(i), childrenMap));
            if (i < children.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}->(").append(node).append(")");
        return sb.toString();
    }
}
