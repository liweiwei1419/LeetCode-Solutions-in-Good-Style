import java.util.ArrayDeque;

/**
 * @author liweiwei1419
 * @date 2019/10/12 5:26 下午
 */
public class Solution5 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 左边界滑出
            if (i >= k && queue.getFirst() == i - k) {
                queue.removeFirst();
            }

            // 在 nums[i] 加入之前考虑把不可能的值弹出
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }

            queue.add(i);
            // 记录结果
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}
