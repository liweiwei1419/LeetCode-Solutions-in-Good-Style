import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/22 12:10 上午
 */
public class Solution8 {

    // 计数排序 CountingSort

    private static final int OFFSET = 50000;

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        // 因为 -50000 <= A[i] <= 50000
        // 所以"桶" 的大小为 50000 - (-50000) = 10_0000
        // 并且设置偏移 OFFSET = 50000，目的是让每一个数都能够大于等于 0
        // 这样就可以作为 count 数组的索引，查询这个数的计数
        int size = 10_0000;

        // 计数数组
        int[] count = new int[size];
        // 计算计数数组
        for (int i = 0; i < len; i++) {
            count[nums[i] + OFFSET]++;
        }

        // 把 count 数组变成前缀和数组
        for (int i = 1; i < size; i++) {
            count[i] += count[i - 1];
        }

        List<Integer> res = new ArrayList<>(len);
        // 为了保证稳定性，从后向前赋值
        for (int i = len - 1; i >= 0; i--) {
            int index = count[nums[i] + OFFSET] - 1;
            res.add(index, nums[i]);
            count[nums[i] + OFFSET]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 4, 5, 6, 1};
        Solution solution = new Solution();
        List<Integer> res = solution.sortArray(nums);
        System.out.println(res);
    }
}
