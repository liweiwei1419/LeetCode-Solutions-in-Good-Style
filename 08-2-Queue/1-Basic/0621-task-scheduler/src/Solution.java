import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26, Comparator.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.offer(count[i]);
            }
        }

        int res = 0;
        // 临时队列，用于存放需要冷却的任务
        Queue<Integer> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {

            // 注意：这里是 n + 1，即在 n + 1 个时间单位内，不能有重复任务

            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    int cnt = maxHeap.poll();
                    if (cnt > 1) {
                        // 因为完成了一个任务，接下来还有 cnt - 1 次任务
                        queue.add(cnt - 1);
                    }
                }
                res++;
                if (maxHeap.isEmpty() && queue.isEmpty()) {
                    break;
                }
            }

            while (!queue.isEmpty()) {
                maxHeap.offer(queue.poll());
            }
        }
        return res;
    }
}