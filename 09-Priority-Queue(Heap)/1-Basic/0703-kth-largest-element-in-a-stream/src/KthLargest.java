import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(k);
        this.k = k;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            add(nums[i]);
        }
    }

    // 注意特殊测试用例：nums 为空的情况，此时 minHeap.peek() 可能得到的值为空

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
            return minHeap.peek();
        } else {
            Integer top = minHeap.peek();
            if (val <= top) {
                return top;
            } else {
                minHeap.poll();
                minHeap.offer(val);
                return minHeap.peek();
            }
        }
    }
}