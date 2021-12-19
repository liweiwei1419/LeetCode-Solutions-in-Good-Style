import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    private int mstCost;

    public int getMstCost() {
        return mstCost;
    }

    private List<int[]> mst;

    public List<int[]> getMst() {
        return mst;
    }

    public Prim(int V, int[][] edges) {
        int len = edges.length;
        if (len < V - 1) {
            throw new IllegalArgumentException("参数错误");
        }
        mst = new ArrayList<>(len - 1);

        Set<int[]>[] adj = new HashSet[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] edge : edges) {
            // [from, to, weight]
            adj[edge[0]].add(new int[]{edge[0], edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[1], edge[0], edge[2]});
        }

        boolean[] visited = new boolean[V];
        visited[0] = true;

        // PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, (o1, o2) -> o1[2] - o2[2]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o[2]));
        minHeap.addAll(adj[1]);

        int count = 0;
        while (!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();

            if (visited[edge[0]] && visited[edge[1]]) {
                continue;
            }

            this.mstCost += edge[2];
            mst.add(new int[]{edge[0], edge[1], edge[2]});
            count++;
            if (count == (V - 1)) {
                break;
            }

            int newV;
            if (visited[edge[0]]) {
                newV = edge[1];
            } else {
                newV = edge[0];
            }

            visited[newV] = true;
            for (int[] successor : adj[newV]) {
                if (!visited[successor[1]]) {
                    minHeap.add(successor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        int[][] edges = {{0, 1, 4},
                {0, 5, 8},
                {1, 2, 8},
                {1, 5, 11},
                {2, 3, 3},
                {2, 6, 2},
                {3, 4, 3},
                {4, 5, 8},
                {4, 6, 6},
                {5, 6, 7},
        };
        Prim prim = new Prim(V, edges);
        int mstCost = prim.getMstCost();
        System.out.println("最小生成树的权值之和：" + mstCost);
        List<int[]> mst = prim.getMst();
        System.out.println("最小生成树的边的列表：");
        for (int[] edge : mst) {
            System.out.println("[" + edge[0] + "-" + edge[1] + "]" + "，权值：" + edge[2]);
        }
    }
}
