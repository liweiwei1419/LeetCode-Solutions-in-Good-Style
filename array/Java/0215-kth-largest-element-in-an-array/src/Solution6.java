import java.util.PriorityQueue;

public class Solution6 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1, (a, b) -> (a - b));
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() == k + 1) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
