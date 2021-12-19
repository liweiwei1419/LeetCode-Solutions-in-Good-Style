import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;

        int size = 1 << len;
        List<List<Integer>> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<>(len);
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = solution3.subsets(nums);
        System.out.println(res);
    }
}