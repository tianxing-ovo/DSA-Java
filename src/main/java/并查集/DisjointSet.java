package 并查集;

import java.util.Arrays;

/**
 * 并查集: 多个树组成的森林
 *
 * @author tianxing
 */
public class DisjointSet {
    /**
     * i: 元素
     * parent[i]: 元素父节点
     */
    int[] parent;

    /**
     * i: 元素
     * size[i]: 树的节点数量
     */
    int[] size;

    int count; // 分组数量

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
     */
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 查找元素i的根节点
     */
    public int find(int i) {
        // 路径压缩
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    /**
     * 合并元素x和元素y到同一分组中
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
        return "parent: " + Arrays.toString(parent) + "  size: " + Arrays.toString(size);
    }
}
