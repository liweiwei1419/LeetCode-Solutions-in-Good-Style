import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || len < k) {
            return new int[0];
        }

        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(len - k + 1);
        for (int i = 0; i < len; i++) {
            // 判断队首元素是否移出滑动窗口
            if (i >= k && !deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }

            // 依次判断待添加元素是否比队首元素大，注意可以取等号
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }

            // 加入队列的是下标
            deque.addLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}