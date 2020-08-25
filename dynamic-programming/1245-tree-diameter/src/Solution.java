import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private List<Integer>[] adj;

    /**
     * 树的特点是只会有一个父亲结点
     */
    private int[] from;
    private int res;

    public int treeDiameter(int[][] edges) {
        // 第 1 步：建图
        buildGraph(edges);

        // 第 2 步：深度有点遍历，得到 from 数组
        dfs(0, -1);

        // 第 3 步：解决这个问题
        solve(0, -1);
        return res;
    }

    /**
     * @param v
     * @param father
     */
    private void dfs(int v, int father) {
        // 每一遍历的时候，记录从谁那里过来
        from[v] = father;

        // 找到后继结点，如果后继结点 = 过来的结点
        List<Integer> successors = adj[v];
        for (Integer successor : successors) {
            if (successor == father) {
                continue;
            }
            dfs(successor, v);
        }

    }

    private void buildGraph(int[][] edges) {
        // 边数
        int E = edges.length;
        // 顶点数
        int V = edges.length + 1;
        from = new int[V];

        adj = new ArrayList[V];
        // 初始化邻接表
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // 构建邻接表
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }
    }


    private int solve(int v, int father) {
        List<Integer> paths = new ArrayList<>();
        List<Integer> successors = adj[v];
        for (Integer successor : successors) {
            if (successor == father) {
                continue;
            }
            paths.add(solve(successor, v));
        }

        Collections.sort(paths);

        int size = paths.size();

        if (size == 0) {
            return 1;
        } else if (size == 1) {
            res = Math.max(res, paths.get(0));
            return paths.get(0) + 1;
        } else {
            res = Math.max(res, paths.get(size - 1) + paths.get(size - 2));
            return paths.get(size - 1) + 1;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
        // int[][] edges = {{0, 1}, {1, 2}, {0, 3}, {3, 4}, {2, 5}, {3, 6}};
        Solution solution = new Solution();
        int res = solution.treeDiameter(edges);
        System.out.println(res);
    }
}
