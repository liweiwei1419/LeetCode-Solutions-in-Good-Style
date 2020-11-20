import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        int len = arr.length;
        boolean[] visited = new boolean[len];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();

            int right = top + arr[top];
            int left = top - arr[top];

            if (right < len && !visited[right]) {
                visited[right] = true;
                queue.offer(right);
                if (arr[right] == 0) {
                    return true;
                }
            }

            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                queue.offer(left);
                if (arr[left] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}