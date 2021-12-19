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

        // 最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26, Comparator.reverseOrder());
        for (int i = 0; i < 26; i++) {
            // 把次数大于 0 的任务加入最大堆
            if (count[i] > 0) {
                maxHeap.offer(count[i]);
            }
        }

        // 依次拿出执行次数最多的任务
        int res = 0;
        // 临时队列，用于存放需要冷却的任务
        Queue<Integer> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            // 注意：这里是 n + 1，即在 n + 1 个时间单位内，不能有重复任务
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    int front = maxHeap.poll();
                    if (front > 1) {
                        // 因为完成了一个任务，接下来还有 front - 1 次任务
                        queue.add(front - 1);
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