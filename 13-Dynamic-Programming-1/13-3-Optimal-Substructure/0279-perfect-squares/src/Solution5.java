import java.util.LinkedList;
import java.util.Queue;

public class Solution5 {

    public int numSquares(int n) {
        // 是否访问过
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                for (int k = 1; k * k <= top; k++) {
                    if (k * k == top) {
                        return step;
                    }

                    int next = top - k * k;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step ++;
        }
        // 正常情况下程序不会运行到这里
        throw new IllegalArgumentException("参数错误");
    }
}