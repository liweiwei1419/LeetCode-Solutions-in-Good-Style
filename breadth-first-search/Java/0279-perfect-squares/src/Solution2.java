import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class Solution2 {

    public int numSquares(int n) {
        Set<Integer> visited = new HashSet<>();
        int step = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int num = queue.poll();
                for (int i = 1; i * i <= num; i++) {
                    int next = num - i * i;
                    if (next == 0) {
                        return step;
                    }
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return 0;
    }
}
