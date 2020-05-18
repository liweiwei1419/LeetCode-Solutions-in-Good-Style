import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    public int numSquares(int n) {
        // 是否访问过
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int step = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int head = queue.poll();
                for (int k = 1; k * k <= head; k++) {
                    if (k * k == head) {
                        return step;
                    }

                    int next = head - k * k;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step ++;
        }

        // 正常情况下是不会走到这句的
        throw new IllegalArgumentException("参数错误");
    }

    public static void main(String[] args) {
        int n = 7168;
        Solution s = new Solution();
        int numSquares = s.numSquares(n);
        System.out.println(numSquares);
    }
}