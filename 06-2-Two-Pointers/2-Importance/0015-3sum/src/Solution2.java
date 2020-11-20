import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // 暴力解法：问题，不方便去除重复元素

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(len - 3);
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> cur = new ArrayList<>(3);
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[k]);
                        res.add(cur);
                    }
                }
            }
        }
        return res;
    }
}