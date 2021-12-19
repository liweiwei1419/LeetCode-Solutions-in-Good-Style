import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    // 方法三：位运算

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;

        int size = 1 << len;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<>(len);

            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                subset.add(nums[j]);
            }
            res.add(subset);
        }
        return res;
    }
}