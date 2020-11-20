import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int windowLen = len - k + 1;
        double[] res = new double[windowLen];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 下一个要填的值
        int next = 0;
        // 循环不变量：
        // 1、maxHeap 的堆顶小于等于 minHeap 的堆顶
        // 2、maxHeap.size() = minHeap.size() 或者
        // 3、maxHeap.size() = minHeap.size() + 1，这样中位数就在 maxHeap 的堆顶
        for (int i = 0; i < len; i++) {
            // 步骤 1：加入元素的时候，保持第 1、2、3 点
            maxHeap.add(nums[i]);
            minHeap.add(maxHeap.poll());
            if ((i & 1) == 0) {
                // 这个语义太难理解：
                // 如果还未添加 nums[i] 之前是偶数，那么添加 nums[i] 的效果是 maxHeap 多 1 个元素
                maxHeap.add(minHeap.poll());
            }
            // 步骤 2：移除窗口外的值，移除滑动窗口的左边界
            // 假设修正法：默认是大顶堆移除了一个元素
            if (i >= k) {
                int removeFrom = 1;
                // 如果不是在最小堆，就在最大堆
                if (minHeap.contains(nums[i - k])) {
                    minHeap.remove(nums[i - k]);
                    removeFrom = 0;
                } else {
                    maxHeap.remove(nums[i - k]);
                }
                // 步骤 3：保持第 2、3 点
                if ((i & 1) == 1 && removeFrom == 1) {
                    maxHeap.add(minHeap.poll());
                }
                if ((i & 1) == 0 && removeFrom == 0) {
                    minHeap.add(maxHeap.poll());
                }
            }
            // 步骤 4：求滑动窗口的中位数
            if (i >= k - 1) {
                if (maxHeap.size() > minHeap.size()) {
                    res[next] = maxHeap.peek();
                } else {
                    res[next] = minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
                }
                next++;
            }
        }
        return res;
    }
}