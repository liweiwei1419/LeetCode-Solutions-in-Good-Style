import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liweiwei1419
 * @date 2019/10/12 6:11 下午
 */
public class Solution7 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }

        // 0 1 2 3 4 5 , k = 3
        //     0 1 2 3
        int[] res = new int[len - k + 1];
        // 存索引值，因为需要知道它什么时候应该被删除
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            // 先考虑收缩左区间
            if (i >= k && deque.getFirst() == i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.add(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
