import java.util.PriorityQueue;

/**
 * @author liwei
 * @date 2019/8/10 3:46 PM
 */
public class Solution10 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k > len) {
            throw new IllegalArgumentException("参数错误");
        }
        // 使用一个含有 len 个元素的最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> b - a);
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        Solution3 solution3 = new Solution3();
        int solution2KthLargest = solution3.findKthLargest(nums, k);
        System.out.println(solution2KthLargest);
    }
}
