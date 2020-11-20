import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int len = dislikes.length;
        if (len < 2) {
            return true;
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // 着色
        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            adj.get(dislike[0]).add(dislike[1]);
            adj.get(dislike[1]).add(dislike[0]);
        }
        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0 && dfs(i, 1, adj, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int color, Map<Integer, List<Integer>> adj, int[] colors) {
        colors[i] = color;
        for (Integer index : adj.get(i)) {
            if (colors[index] == color) {
                return true;
            }
            if (colors[index] == 0 && dfs(index, -color, adj, colors)) {
                return true;
            }
        }
        return false;
    }
}