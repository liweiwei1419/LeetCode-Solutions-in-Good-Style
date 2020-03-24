import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/2 12:13 下午
 */
public class Solution {

    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);
        if (len == 0) {
            return res;
        }
        for (int i = 0; i < len - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            res.add(count);
        }
        res.add(0);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        Solution solution = new Solution();
        List<Integer> res = solution.countSmaller(nums);
        System.out.println(res);
    }
}
