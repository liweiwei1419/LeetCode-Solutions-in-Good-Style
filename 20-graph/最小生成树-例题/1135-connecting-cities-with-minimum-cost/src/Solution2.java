import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution2 {

    // Prim 算法

    public int minimumCost(int N, int[][] connections) {
        int len = connections.length;
        if (len < N - 1) {
            return -1;
        }

        Set<int[]>[] adj = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] connection : connections) {
            // [from, to, weight]
            adj[connection[0]].add(new int[]{connection[0], connection[1], connection[2]});
            adj[connection[1]].add(new int[]{connection[1], connection[0], connection[2]});
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        // PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, (o1, o2) -> o1[2] - o2[2]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o[2]));
        for (int[] connection : adj[1]) {
            minHeap.add(connection);
        }

        int mstCost = 0;
        int count = 0;
        while (!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();

            if (visited[edge[0]] && visited[edge[1]]) {
                continue;
            }

            mstCost += edge[2];
            count++;
            if (count == N - 1) {
                break;
            }

            int newV;
            if (visited[edge[0]]) {
                newV = edge[1];
            } else {
                newV = edge[0];
            }

            visited[newV] = true;


            for (int[] connection : adj[newV]) {
                if (!visited[connection[1]]) {
                    minHeap.add(connection);
                }
            }
        }

        return mstCost;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int N = 3;
        int[][] conections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        int res = solution2.minimumCost(N, conections);
        System.out.println(res);
    }
}
