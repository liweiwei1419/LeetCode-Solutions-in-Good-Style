import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution5 {

    // 方法三：暴力 BFS（效率低）

    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        // starts from position 0 with speed 1
        queue.offer(new int[]{0, 1});

        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 1);

        for (int level = 0; !queue.isEmpty(); level++) {
            for (int k = queue.size(); k > 0; k--) {
                // cur[0] is position; cur[1] is speed
                int[] cur = queue.poll();
                if (cur[0] == target) {
                    return level;
                }

                // accelerate instruction 加速指令
                int[] nexts = new int[]{cur[0] + cur[1], cur[1] << 1};
                String key = (nexts[0] + " " + nexts[1]);

                if (!visited.contains(key) && 0 < nexts[0] && nexts[0] < (target << 1)) {
                    queue.offer(nexts);
                    visited.add(key);
                }

                // reverse instruction 反向指令
                nexts = new int[]{cur[0], cur[1] > 0 ? -1 : 1};
                key = (nexts[0] + " " + nexts[1]);
                if (!visited.contains(key) && 0 < nexts[0] && nexts[0] < (target << 1)) {
                    queue.offer(nexts);
                    visited.add(key);
                }
            }
        }
        return -1;
    }
}