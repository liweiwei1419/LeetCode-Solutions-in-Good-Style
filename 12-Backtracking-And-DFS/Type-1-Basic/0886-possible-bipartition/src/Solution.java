import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[] colors;
    private List<Integer>[] adj;
    private boolean[] visited;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int len = dislikes.length;
        if (len < 2) {
            return true;
        }

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : dislikes) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        colors = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i, int color) {
        visited[i] = true;
        colors[i] = color;
        List<Integer> successors = adj[i];
        if (successors == null) {
            return false;
        }

        for (int successor : successors) {
            if (!visited[successor]) {
                if (dfs(successor, 1 - color)) {
                    return true;
                }
            } else {
                if (colors[i] == colors[successor]) {
                    return true;
                }
            }
        }
        return false;
    }
}