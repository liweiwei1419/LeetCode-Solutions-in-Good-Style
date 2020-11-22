import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    // 方法：广度优先遍历

    public int jump(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        int target = len - 1;
        int minStep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer top = queue.poll();
                if (top == target) {
                    return minStep;
                }

                for (int j = top + 1; j <= Math.min(top + nums[top], len - 1); j++) {
                    if (visited.contains(j)) {
                        continue;
                    }
                    queue.add(j);
                    visited.add(j);
                }
            }
            minStep++;
        }
        return minStep;
    }
}