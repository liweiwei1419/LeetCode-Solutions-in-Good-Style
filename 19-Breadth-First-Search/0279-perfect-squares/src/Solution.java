import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean[] visited = new boolean[n + 1];
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int head = queue.poll();
                for (int j = 1; j * j <= head; j++) {
                    if (j * j == head) {
                        return step;
                    }

                    int next = head - j * j;
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