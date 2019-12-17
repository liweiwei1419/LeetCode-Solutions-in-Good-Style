import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution8 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        // 特判
        if (len == 0) {
            return new int[]{};
        }
        // 结果集
        List<Integer> res = new ArrayList<>();
        // 滑动窗口，注意：保存的是索引值
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);

        for (int i = 0; i < len; i++) {
            // 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            // 那么将它弹出
            if (i >= k && i - k == deque.getFirst()) {
                deque.pollFirst();
            }

            // 如果滑动窗口非空，新进来的数比队列里已经存在的数还要大
            // 则说明已经存在数一定不会是滑动窗口的最大值（它们毫无出头之日）
            // 将它们弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // 队首一定是滑动窗口的最大值的索引
            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }

        int size = res.size();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
