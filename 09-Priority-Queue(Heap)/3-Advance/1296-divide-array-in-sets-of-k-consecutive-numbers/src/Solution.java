import java.util.PriorityQueue;

public class Solution {

    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);
        for (int num : nums) {
            minHeap.offer(num);
        }

        while (!minHeap.isEmpty()) {
            Integer top = minHeap.poll();

            for (int i = 1; i < k; i++) {
                // 从 1 开始，正好需要移除 k - 1 个元素
                // i 正好就是相对于 top 的偏移
                if (!minHeap.remove(top + i)) {
                    // 如果移除失败，说明划分不存在，直接返回 false 即可
                    return false;
                }
            }
        }
        return true;
    }
}