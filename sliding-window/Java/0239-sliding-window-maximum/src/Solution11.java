import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liweiwei1419
 * @date 2019/11/27 6:09 上午
 */
public class Solution11 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < 1) {
            return new int[0];
        }
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(k + 1);
        for (int i = 0; i < len; i++) {
            // 考虑删除队首元素
            if (i >= k && !deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            // 形成一个单调不减的队列，队首是滑动窗口的最大值
            // 记录结果集
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
