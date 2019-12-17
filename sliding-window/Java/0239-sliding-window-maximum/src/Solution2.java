import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liweiwei1419
 * @date 2019/10/12 3:47 下午
 */
public class Solution2 {

    /**
     * 双端队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (i >= k && queue.getFirst() == i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.add(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }

}
