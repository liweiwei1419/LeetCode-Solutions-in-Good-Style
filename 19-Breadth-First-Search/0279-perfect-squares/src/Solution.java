import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        // 由于图中存在环，所以需要记录哪些结点是否访问过
        boolean[] visited = new boolean[n + 1];

        int step = 1;
        while (!queue.isEmpty()) {
            // 每一次扩张，保存当前队列的结点总数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int front = queue.poll();
                for (int j = 1; j * j <= front; j++) {
                    if (j * j == front) {
                        return step;
                    }

                    int next = front - j * j;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return 0;
    }
}