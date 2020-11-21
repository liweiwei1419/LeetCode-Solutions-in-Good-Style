import java.util.LinkedList;
import java.util.Queue;


public class Solution4 {

    // 方法：广度优先遍历

    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int num = front[0];
            int step = front[1];

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (!visited[a]) {
                    if (a == 0) {
                        return step + 1;
                    }
                    queue.offer(new int[]{num - i * i, step + 1});
                    // 注意：应该马上被标记为已经访问
                    visited[num - i * i] = true;
                }
            }
        }
        throw new IllegalStateException("No Solution.");
    }
}