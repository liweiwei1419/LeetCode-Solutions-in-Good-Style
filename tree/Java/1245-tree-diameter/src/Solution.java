import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/2 11:01 下午
 */
public class Solution {

    List<List<Integer>> adj;
    // 树的特点是只会有一个父亲
    int[] from;
    int res;

    public int treeDiameter(int[][] edges) {
        // 边数
        int E = edges.length;
        // 顶点数
        int V = edges.length + 1;
        from = new int[V];

        adj = new ArrayList<>(V);
        // 初始化邻接表
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // 构建邻接表
        for (int i = 0; i < E; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            addEdge(a, b);
            addEdge(b, a);
        }

        dfs(0, -1);
        solve(0, -1);
        return res;
    }

    private int solve(int v, int father) {
        List<Integer> paths = new ArrayList<>();
        List<Integer> successors = adj.get(v);
        for (Integer successor : successors) {
            if (successor == father) {
                continue;
            }
            paths.add(solve(successor, v));
        }

        Collections.sort(paths);

        int size = paths.size();
        System.out.println(paths);

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

    /**
     * 进行一次深度优先遍历
     * @param v
     * @param father
     */
    private void dfs(int v, int father) {
        // 每一遍历的时候，记录一下是从谁那里过来的
        from[v] = father;

        List<Integer> successors = adj.get(v);
        for (Integer successor : successors) {
            if (successor == father) {
                continue;
            }
            dfs(successor, v);
        }

    }

    private void addEdge(int a, int b) {
        adj.get(a).add(b);
    }


    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
        // int[][] edges = {{0, 1}, {1, 2}, {0, 3}, {3, 4}, {2, 5}, {3, 6}};
        Solution solution = new Solution();
        int res = solution.treeDiameter(edges);
        System.out.println(res);
    }
}
