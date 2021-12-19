import java.util.PriorityQueue;

public class Solution {

    // 使用优先队列

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1L);

        // 因为数字可能越乘越大，所以需要声明成 Long 类型
        Long res = minHeap.peek();

        for (int i = 0; i < n; i++) {
            res = minHeap.poll();

            // 因为有重复元素，要把重复元素去掉
            while (!minHeap.isEmpty() && res.equals(minHeap.peek())) {
                minHeap.poll();
            }

            minHeap.offer(res * 2);
            minHeap.offer(res * 3);
            minHeap.offer(res * 5);
        }
        return res.intValue();
    }
}